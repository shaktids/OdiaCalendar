package ennovic.example.dasshak.odiacalendar;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dasshak.odiacalendar.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    InterstitialAd mInterstitialAl;
    private InterstitialAd interstitial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        ImageAdapter adapter=new ImageAdapter(this);
        viewPager.setAdapter(adapter);
        //1st adView
        MobileAds.initialize(this,"ca-app-pub-7856118129660697~2519796649");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //2 nd add view1


// Prepare the Interstitial Ad
        interstitial = new InterstitialAd(MainActivity.this);
// Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));

        interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            //public void onAdLoaded() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                //displayInterstitial();
            }

        });
    }

        public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
           if (interstitial.isLoaded()) {
               interstitial.show();
            }
        }

    @Override
    public void onBackPressed() {
        displayInterstitial();
        finish();
    }

}
