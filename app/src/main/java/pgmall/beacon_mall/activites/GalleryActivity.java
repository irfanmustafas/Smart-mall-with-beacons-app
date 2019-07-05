package pgmall.beacon_mall.activites;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pgmall.beacon_mall.modules.ImageUrl;
import pgmall.mall_4.R;
import pgmall.beacon_mall.adapters.GalleryDataAdapter;

public class GalleryActivity extends AppCompatActivity {
    ImageView imageView;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery2);
        imageView = findViewById(R.id.imageView);
        recyclerView = findViewById(R.id.recyclerView);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        ArrayList imageUrlList = prepareData();
        GalleryDataAdapter galleryDataAdapter = new GalleryDataAdapter(getApplicationContext(), imageUrlList);
        recyclerView.setAdapter(galleryDataAdapter);
    }

    private ArrayList prepareData() {
        Intent in = getIntent();

        String uri11 = in.getStringExtra("uri11");
        String uri12 = in.getStringExtra("uri12");
        String uri13 = in.getStringExtra("uri13");
        String uri14 = in.getStringExtra("uri14");
        String uri15 = in.getStringExtra("uri15");
       // Toast.makeText(this, uri11, Toast.LENGTH_SHORT).show();
        String imageUrls[] = {
                uri11,
                uri12,
                uri13,
                uri14,
                uri15/*,
                "http://thenewswheel.com/wp-content/uploads/2017/03/10-Famous-New-Yorkers-with-Incredibly-Cool-Cars-Feature.jpg",
                "http://beverlyhillsmagazine.com/wp-content/uploads/Ferrrari-LaFerrari-1.jpeg",
                "https://i.pinimg.com/736x/51/22/24/512224b7565c4adf4cd66bba6184bf78--most-expensive-expensive-cars.jpg",
                "http://beverlyhillsmagazine.com/wp-content/uploads/Bentley-Aston-Martin-Dream-Cars-Maybach-Doge-Charger-Cool-Cars-Race-Car-Magazine-VIP-Style-cars-Supercars-Beverly-Hills-Magazine-3-e1492551913276.jpg",
                "https://lh6.ggpht.com/78tnPMNVWns7NsmTjO3C9QQz-jRxLIjL1yE8VtJC_Epv24r4AKjW4e14BojEKbcMPCdr%3Dh310",
                "https://s.aolcdn.com/dims-global/dims3/GLOB/legacy_thumbnail/916x515/quality/95/https://s.blogcdn.com/slideshows/images/slides/400/662/5/S4006625/slug/l/01-2017-chevrolet-corvette-gs-fd-1-1.jpg",
                "https://s-media-cache-ak0.pinimg.com/originals/80/69/92/806992aaf90fcb40065a600ae485002a.jpg"*/};

        ArrayList imageUrlList = new ArrayList<>();
        for (int i = 0; i < imageUrls.length; i++) {
            ImageUrl imageUrl = new ImageUrl();
            imageUrl.setImageUrl(imageUrls[i]);
            imageUrlList.add(imageUrl);
        }
      //  Log.d("GalleryActivity", "List count: " + imageUrlList.size());
        return imageUrlList;
    }
}
