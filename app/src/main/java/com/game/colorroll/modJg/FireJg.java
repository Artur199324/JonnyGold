package com.game.colorroll.modJg;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.game.colorroll.actJg.StartActivityJG;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class FireJg {

    private String statusJG;
    private String urlJG;

    public String getStatusJG() {
        return statusJG;
    }

    public void setStatusJG(String statusJG) {
        this.statusJG = statusJG;
    }

    public String getUrlJG() {
        return urlJG;
    }

    public void setUrlJG(String urlJG) {
        this.urlJG = urlJG;
    }

    public void fireJG(StartActivityJG startActivityJG){
        FirebaseRemoteConfig mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(3600)
                .build();
        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);
        mFirebaseRemoteConfig.fetchAndActivate()
                .addOnCompleteListener(startActivityJG, new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull Task<Boolean> task) {
                        if (task.isSuccessful()) {
                            boolean updated = task.getResult();
                            Log.d("weq", "Config params updated: " + updated);
                            setStatusJG(mFirebaseRemoteConfig.getString("statusJg"));
                            setUrlJG(mFirebaseRemoteConfig.getString("urlJG"));
                            Log.d("weq", getStatusJG());
                        } else {

                        }

                    }
                });
    }
}
