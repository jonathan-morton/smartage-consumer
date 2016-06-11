package consumer.smartage.hackathon.att.smartage_consumer.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import consumer.smartage.hackathon.att.smartage_consumer.R;
import consumer.smartage.hackathon.att.smartage_consumer.activities.MainConsumerActivity;
import consumer.smartage.hackathon.att.smartage_consumer.models.Trashcan;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MapConsumerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MapConsumerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapConsumerFragment extends Fragment implements OnMapReadyCallback {

    private static GoogleMap map;
    private List<Trashcan> trashCans;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MapConsumerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapConsumerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MapConsumerFragment newInstance(String param1, String param2) {
        MapConsumerFragment fragment = new MapConsumerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (container == null) {
            return null;
        }
        View view = (FrameLayout) inflater.inflate(R.layout.fragment_map_consumer, container, false);
        setupMap();

        getTrashCans();

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroy() {
        if (map != null) {
            MainConsumerActivity.fragmentManager.beginTransaction()
                    .remove(MainConsumerActivity.fragmentManager.findFragmentById(R.id.map)).commit();
            map = null;
        }
        super.onDestroy();
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void setupMap() {
        if (map == null) {
            // Try to obtain the map from the SupportMapFragment.
            SupportMapFragment mapFragment = ((SupportMapFragment) getChildFragmentManager()
                    .findFragmentById(R.id.map));
            mapFragment.getMapAsync(this);
            // Check if we were successful in obtaining the map.
            if (map != null) {
                map.setMyLocationEnabled(true);
            }
            /*//C For dropping a marker at a point on the Map
            map.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("My Home").snippet("Home Address"));
            // For zooming automatically to the Dropped PIN Location
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude,
                    longitude), 12.0f));*/
        }
    }

    private void createMarkers() {

        List<Marker> markers = new ArrayList<Marker>();
        for (Trashcan trashcan : trashCans) {
            Marker marker;
            String realCan = "";
            if (trashcan.getId() == 1) {
                realCan = "real: ";
            }
            marker = map.addMarker(new MarkerOptions()
                    .position(new LatLng(trashcan.getLatitude(), trashcan.getLongitude()))
                    .title(realCan + "capacity: " + trashcan.getFs()));

            markers.add(marker);
        }

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Marker marker : markers) {
            builder.include(marker.getPosition());
        }
        LatLngBounds bounds = builder.build();
        int padding = 30; // offset from edges of the map in pixels
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
        map.animateCamera(cu);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
    }

    public void getTrashCans() {
        TrashCanService trashCanService = TrashCanService.retrofit.create(TrashCanService.class);

        final Call<List<Trashcan>> call =
                trashCanService.getTrashCans();

        call.enqueue(new Callback<List<Trashcan>>() {
            @Override
            public void onResponse(Call<List<Trashcan>> call, Response<List<Trashcan>> response) {
                trashCans = response.body();
                createMarkers();
            }

            @Override
            public void onFailure(Call<List<Trashcan>> call, Throwable t) {
                Log.e("Smartage", t.getMessage());
                Toast.makeText(getActivity(), "There was an error getting the trash cans", Toast.LENGTH_LONG).show();
            }
        });
    }
}
