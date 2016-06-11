package consumer.smartage.hackathon.att.smartage_consumer.components;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Locale;

import consumer.smartage.hackathon.att.smartage_consumer.R;
import consumer.smartage.hackathon.att.smartage_consumer.activities.MainDriverActivity;
import consumer.smartage.hackathon.att.smartage_consumer.fragments.MapDriverFragment;
import consumer.smartage.hackathon.att.smartage_consumer.fragments.TrashCanListDriverFragment;

/**
 * Created by Jonathan Morton on 6/11/16.
 */

public class HomeTabPager extends FragmentPagerAdapter {

    private MainDriverActivity activity;
    private MapDriverFragment mapFragment;
    private TrashCanListDriverFragment listFragment;

    public enum Tab {
        MAP_TAB,
        LIST_TAB;

        private static final Tab[] valuesCache = Tab.values();

        public static Tab fromPosition(int position) {
            return valuesCache[position];
        }

        public static int count() {
            return valuesCache.length;
        }
    }

    public HomeTabPager(MainDriverActivity activity) {
        super(activity.getSupportFragmentManager());
        this.activity = activity;
    }

    @Override
    public Fragment getItem(int position) {
        switch (Tab.fromPosition(position)) {
            case MAP_TAB:
                if (mapFragment == null) {
                    mapFragment = MapDriverFragment.newInstance(position);
                }
                return mapFragment;
            case LIST_TAB:
                if (listFragment == null) {
                    listFragment = TrashCanListDriverFragment.newInstance(position);
                }
                return listFragment;
        }
        return null;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() { return Tab.count(); }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (Tab.fromPosition(position)) {
            case MAP_TAB:
                return activity.getString(R.string.tab_title_map).toUpperCase(l);
            case LIST_TAB:
                return activity.getString(R.string.tab_title_trash_can_list).toUpperCase(l);
        }
        return null;
    }
}
