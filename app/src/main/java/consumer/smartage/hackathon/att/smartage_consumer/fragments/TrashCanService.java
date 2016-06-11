package consumer.smartage.hackathon.att.smartage_consumer.fragments;

/**
 * Created by Jonathan Morton on 6/11/16.
 */

import java.util.List;

import consumer.smartage.hackathon.att.smartage_consumer.models.Trashcan;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

interface TrashCanService {
    @GET("trashcans")
    Call<List<Trashcan>> getTrashCans();

    String networkUrl = "http://192.168.1.149:2345/";

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(networkUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
