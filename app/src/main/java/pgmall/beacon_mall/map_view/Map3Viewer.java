package pgmall.beacon_mall.map_view;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import pgmall.mall_4.R;


public class Map3Viewer extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_map);
        webView = (WebView) findViewById(R.id.nyc_poi_webview);
        webView.setWebViewClient(new WebViewClient());
        Intent i = getIntent();
        final String map_id = i.getStringExtra("map1");
        String place = map_id;
        //  Toast.makeText(this, place, Toast.LENGTH_SHORT).show();
        webView.loadUrl("https://maps.mapwize.io/#/p/city_mall_map/" + place + "?k=yoRLjct74YZZxkij&venueId=5ccddd390cd5de0016d20628&organizationId=5ccc92770cd5de0016d1e393&z=17.299");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}

