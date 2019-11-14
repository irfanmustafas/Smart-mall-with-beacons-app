package pgmall.beacon_mall.activites;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import pgmall.beacon_mall.adapters.adapter_fragments;
import pgmall.mall_4.R;

public class MainActivity extends AppCompatActivity {
    protected TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTabBar();
    }
    private void setTabBar(){
        tabLayout = findViewById(R.id.activityMain_tabLayout);
        ViewPager viewPager = findViewById(R.id.activityMain_viewPager);
        adapter_fragments adapter_fragments = new adapter_fragments(getSupportFragmentManager());
        viewPager.setAdapter(adapter_fragments);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_black);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_search_black);
        tabLayout.getTabAt(2).setIcon(R.drawable.beacon);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_location_on_black);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_settings_black_24dp);

    }
}
