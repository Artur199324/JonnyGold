package com.game.colorroll.modJg;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.game.colorroll.actJg.GameActivityJg;
import com.game.colorroll.actJg.RecordActivityJG;
import com.game.colorroll.actJg.RulActivityJG;
import com.game.colorroll.actJg.SettingsActivityJg;
import com.game.colorroll.actJg.StartActivityJG;

public class ButtonJG {

    Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void buttonJG(Button buttonStJG, Button buttonRulJG, Button  buttonCloJG, Button buttonsettingsJG, Button buttonrecordJG,MediaJG mediaJG,int jj){

        buttonStJG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity.getApplicationContext(), GameActivityJg.class));
                activity.finishAffinity();
                mediaJG.mediaPlayStopMG(jj);
            }
        });


        buttonRulJG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity.getApplicationContext(), RulActivityJG.class));
                mediaJG.mediaPlayStopMG(jj);
                activity.finishAffinity();
            }
        });


        buttonCloJG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
                mediaJG.mediaPlayStopMG(jj);

            }
        });


        buttonsettingsJG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity.getApplicationContext(), SettingsActivityJg.class));
                mediaJG.mediaPlayStopMG(jj);
                activity.finishAffinity();
            }
        });


        buttonrecordJG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity.getApplicationContext(), RecordActivityJG.class));
                mediaJG.mediaPlayStopMG(jj);
                activity.finishAffinity();
            }
        });
    }

    public void buttonInJG(Button buttonIn){

       buttonIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               activity.startActivity(new Intent(activity.getApplicationContext(), StartActivityJG.class));
               activity.finishAffinity() ;
           }
       });
    }
}
