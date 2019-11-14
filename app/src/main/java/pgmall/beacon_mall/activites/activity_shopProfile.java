package pgmall.beacon_mall.activites;


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

public class activity_shopProfile extends AppCompatActivity {
    private TextView tv_name, tv_category, tv_email, tv_phone, tv_webSite, tv_description;
    private ImageView iv_shopIcon;
    private LinearLayout layout_btnCall, layout_btnEmail, layout_btnWebSite;
    private Button btn_map, btn_gallery;
    private String name, phone, email, website, description, category, map_id, uri, uri1, uri2, uri3, uri4, uri5;
    private String[] address = {""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        init();
        getData();
        set_shopIcon();
        setTextViews();
        set_map();
        set_Call();
        set_Email();
        set_gallery();
    }

    private void init() {
        iv_shopIcon = findViewById(R.id.actShopProfile_iv_shopProfile);
        tv_name = findViewById(R.id.actShopProfile_tv_shopName);
        tv_category = findViewById(R.id.actShopProfile_tv_shopCategory);
        tv_email = findViewById(R.id.ema);
        tv_phone = findViewById(R.id.phn);
        tv_webSite = findViewById(R.id.web);
        tv_description = findViewById(R.id.desc1);
        btn_map = findViewById(R.id.actShopProfile_btn_shopLocation);
        layout_btnCall = findViewById(R.id.actShopProfile_Layout_phone);
        layout_btnEmail = findViewById(R.id.actShopProfile_layout_email);
        layout_btnWebSite = findViewById(R.id.actShopProfile_layout_website);
        btn_gallery = findViewById(R.id.gallrybttn);

    }

    private void getData() {
        Intent i = getIntent();
        name = i.getStringExtra("name");
        phone = i.getStringExtra("phone");
        email = i.getStringExtra("email");
        website = i.getStringExtra("website");
        description = i.getStringExtra("description");
        map_id = i.getStringExtra("map_id");
        uri1 = i.getStringExtra("uri1");
        uri2 = i.getStringExtra("uri2");
        uri3 = i.getStringExtra("uri3");
        uri4 = i.getStringExtra("uri4");
        uri5 = i.getStringExtra("uri5");
        uri = i.getStringExtra("uri");
        category = i.getStringExtra("category");
    }

    private void set_shopIcon() {
        try {
            Picasso.with(getApplicationContext())
                    .load(uri)
                    .placeholder(R.drawable.nopic)
                    .fit()
                    .centerCrop()
                    .into(iv_shopIcon);
        } catch (Exception ignored) {
        }

    }

    private void setTextViews() {
        tv_name.setText(name);
        tv_category.setText(category);
        tv_email.setText(email);
        tv_phone.setText(phone);
        tv_webSite.setText(website);
        tv_description.setText(description);

    }

    private void set_map() {
        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_shopProfile.this, Map3Viewer.class);
                intent.putExtra("map1", map_id);
                startActivity(intent);
            }
        });
    }

    private void set_Call() {
        layout_btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phone));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

    private void set_Email() {
        layout_btnEmail.setOnClickListener(new View.OnClickListener() {
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

    }

    private void setLayout_btnWebSite() {
        layout_btnWebSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                startActivity(intent);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

    }

    private void set_gallery() {
        btn_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity_shopProfile.this, activity_gallery.class);
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
