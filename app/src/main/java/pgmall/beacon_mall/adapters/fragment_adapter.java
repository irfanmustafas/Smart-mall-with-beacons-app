package pgmall.beacon_mall.adapters;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import pgmall.beacon_mall.fragments.frag_beacon;
import pgmall.beacon_mall.fragments.frag_home;
import pgmall.beacon_mall.fragments.frag_map;
import pgmall.beacon_mall.fragments.frag_search;
import pgmall.beacon_mall.fragments.frag_setting;

public class fragment_adapter extends FragmentPagerAdapter {
    public fragment_adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new frag_home();
            case 1:
                return new frag_search();
            case 2:
                return new frag_beacon();
            case 3:
                return new frag_map();
            case 4:
                return new frag_setting();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }
}
