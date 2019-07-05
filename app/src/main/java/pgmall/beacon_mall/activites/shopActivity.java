package pgmall.beacon_mall.activites;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import pgmall.mall_4.R;
import pgmall.beacon_mall.map_view.Map3Viewer;

public class shopActivity extends AppCompatActivity {
    TextView shopname, cat, email1, phone1, web1, desc1;
    ImageView icon;
    LinearLayout callbttn, email_button, website_button;
    Button map_button, gallary_button, share_button, virtual_button;

    //-------------buttons-------------------------------------
    //call

    //email
    String[] address = {""};
    //web site
    //----------------------------------------------------------

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Intent i = getIntent();
        final String name = i.getStringExtra("name");
        final String phone = i.getStringExtra("phone");
        String email = i.getStringExtra("email");

        final String website = i.getStringExtra("website");
        String description = i.getStringExtra("describtion");
        final String map_id = i.getStringExtra("map_id");
        final String uri1 = i.getStringExtra("uri1");
        final String uri2 = i.getStringExtra("uri2");
        final String uri3 = i.getStringExtra("uri3");
        final String uri4 = i.getStringExtra("uri4");
        final String uri5 = i.getStringExtra("uri5");
        String uri = i.getStringExtra("uri");
        String category = i.getStringExtra("category");
        // Toast.makeText(this, map_id, Toast.LENGTH_SHORT).show();
        // ------------------------ BUTTONS --------------------------------------------------------
        icon = findViewById(R.id.profile_image);
        try {
            Picasso.with(getApplicationContext())
                    .load(uri)
//                    .error(R.drawable.nopic)
                   .placeholder(R.drawable.nopic)
                    .fit()
                    .centerCrop()
                    .into(icon);
        } catch (Exception e) {
        }
        shopname = findViewById(R.id.shopname);
        shopname.setText(name);
        cat = findViewById(R.id.categorytxt);
        cat.setText(category);

        email1 = findViewById(R.id.ema);
        email1.setText(email);

        phone1 = findViewById(R.id.phn);
        phone1.setText(phone);

        web1 = findViewById(R.id.web);
        web1.setText(website);
        desc1 = findViewById(R.id.desc1);
        desc1.setText(description);

        map_button = findViewById(R.id.mapbuttn);
        callbttn = findViewById(R.id.phonebttn);
        email_button = findViewById(R.id.emailbttn);
        website_button = findViewById(R.id.webbttn);
        gallary_button = findViewById(R.id.gallrybttn);


        map_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(shopActivity.this, Map3Viewer.class);
                intent.putExtra("map1", map_id);
                startActivity(intent);
            }
        });
        callbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phone));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        email_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, address);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
//        website_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
//                startActivity(intent);
//                if (intent.resolveActivity(getPackageManager()) != null) {
//                    startActivity(intent);
//                }
//            }
//        });
        gallary_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(shopActivity.this, GalleryActivity.class);
                i.putExtra("uri11", uri1);
                i.putExtra("uri12", uri2);
                i.putExtra("uri13", uri3);
                i.putExtra("uri14", uri4);
                i.putExtra("uri15", uri5);

                startActivity(i);
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
