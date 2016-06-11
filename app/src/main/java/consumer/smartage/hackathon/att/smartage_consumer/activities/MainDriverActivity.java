package consumer.smartage.hackathon.att.smartage_consumer.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import consumer.smartage.hackathon.att.smartage_consumer.R;
import consumer.smartage.hackathon.att.smartage_consumer.components.HomeTabPager;
import consumer.smartage.hackathon.att.smartage_consumer.fragments.MapDriverFragment;
import consumer.smartage.hackathon.att.smartage_consumer.fragments.TrashCanListDriverFragment;

public class MainDriverActivity extends AppCompatActivity
        implements MapDriverFragment.OnFragmentInteractionListener, TrashCanListDriverFragment.OnFragmentInteractionListener {

    private ViewPager tabViewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_driver);

        fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);

        tabViewPager = (ViewPager) findViewById(R.id.view_pager);
        final HomeTabPager adapter = new HomeTabPager(this);
        tabViewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(tabViewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                tabViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        setupToolbar();
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
