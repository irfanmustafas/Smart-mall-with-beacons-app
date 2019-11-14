package pgmall.beacon_mall.map_view;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import pgmall.mall_4.R;


public class MapViewer extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_map);
        Intent intent = getIntent();
        String ID = intent.getStringExtra("Value1");
     //   String place = ID;

//        if (ID == "0a8ec2a67ed98b4c1cd9335e73378429") {
//            place = "mobile_shop";
//        } else {
//            place = "mobile_shop";
//        }

        webView =  findViewById(R.id.nyc_poi_webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://maps.mapwize.io/#/p/city_mall_map/"+ID+"?k=cfe03f8569546af0&venueId=5ccddd390cd5de0016d20628&organizationId=5ccc92770cd5de0016d1e393&z=16.727");
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

