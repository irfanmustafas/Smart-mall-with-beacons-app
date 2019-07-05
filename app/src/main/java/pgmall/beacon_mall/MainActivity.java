package pgmall.beacon_mall;


import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import pgmall.beacon_mall.adapters.fragment_adapter;
import pgmall.mall_4.R;

public class MainActivity extends AppCompatActivity {
    //implements NavigationView.OnNavigationItemSelectedListener
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_navi_view);

        //----------------------- Icons Bar and Fragments Management -----------------------------------------
        Toolbar toolbar = findViewById(R.id.upper_toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout = findViewById(R.id.mainTabLayout);
        ViewPager viewPager = findViewById(R.id.mainViewPager);
        fragment_adapter fragment_adapter = new fragment_adapter(getSupportFragmentManager());
        viewPager.setAdapter(fragment_adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_black);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_search_black);
        tabLayout.getTabAt(2).setIcon(R.drawable.beacon);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_location_on_black);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_settings_black_24dp);
    }
}
