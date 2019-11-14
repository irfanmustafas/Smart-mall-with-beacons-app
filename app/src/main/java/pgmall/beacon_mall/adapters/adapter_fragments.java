package pgmall.beacon_mall.adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

import pgmall.beacon_mall.fragments.frag_beacon;
import pgmall.beacon_mall.fragments.frag_home;
import pgmall.beacon_mall.fragments.frag_map;
import pgmall.beacon_mall.fragments.frag_search;
import pgmall.beacon_mall.fragments.frag_setting;

public class adapter_fragments extends FragmentPagerAdapter {
    public adapter_fragments(FragmentManager fm) {
        super(fm);
    }

    @NotNull
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

}
