package pgmall.beacon_mall.activites;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pgmall.beacon_mall.modules.ImageUrl;
import pgmall.mall_4.R;
import pgmall.beacon_mall.adapters.adapter_gallery;

public class activity_gallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        setRecyclerView();


    }

    private void setRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.rv_activityGallery);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        ArrayList imageUrlList = prepareData();
        recyclerView.setAdapter(new adapter_gallery(getApplicationContext(), imageUrlList));

    }

    private ArrayList prepareData() {
        Intent in = getIntent();
        String uri11 = in.getStringExtra("uri11");
        String uri12 = in.getStringExtra("uri12");
        String uri13 = in.getStringExtra("uri13");
        String uri14 = in.getStringExtra("uri14");
        String uri15 = in.getStringExtra("uri15");
        String imageUrls[] = {uri11, uri12, uri13, uri14, uri15};

        ArrayList imageUrlList = new ArrayList<>();
        for (int i = 0; i < imageUrls.length; i++) {
            ImageUrl imageUrl = new ImageUrl();
            imageUrl.setImageUrl(imageUrls[i]);
            imageUrlList.add(imageUrl);
        }
        return imageUrlList;
    }
}
