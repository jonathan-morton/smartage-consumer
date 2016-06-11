package consumer.smartage.hackathon.att.smartage_consumer.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import consumer.smartage.hackathon.att.smartage_consumer.R;
import consumer.smartage.hackathon.att.smartage_consumer.fragments.MapConsumerFragment;

public class MainConsumerActivity extends AppCompatActivity
        implements MapConsumerFragment.OnFragmentInteractionListener {

    private Toolbar toolbar;
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_consumer);

        fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = createFragment();
            fragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }

        setupToolbar();
    }

    protected Fragment createFragment() {
        return new MapConsumerFragment();
    }

    private void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
