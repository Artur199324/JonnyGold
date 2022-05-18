package com.game.colorroll.modJg;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.game.colorroll.actJg.StartActivityJG;

public class FbSetEG {

    public void fbSetEG(StartActivityJG startActivityJG){
        FacebookSdk.setAutoInitEnabled(true);
        FacebookSdk.fullyInitialize();
        AppEventsLogger.activateApp(startActivityJG.getApplication());
    }
}
