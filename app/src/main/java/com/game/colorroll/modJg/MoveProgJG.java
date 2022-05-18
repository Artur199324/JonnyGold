package com.game.colorroll.modJg;

import android.os.Handler;
import android.widget.ImageView;

public class MoveProgJG {

    public void moveProJG(ImageView image1,ImageView image2, ImageView image3,int w){
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                image1.setX(image1.getX()+10);
                image2.setX(image2.getX()+10);
                image3.setX(image3.getX()+10);
                if (image1.getX()>w){
                    image1.setX(0);
                }
                if (image2.getX()>w){
                    image2.setX(0);
                }
                if (image3.getX()>w){
                    image3.setX(0);
                }

                handler.postDelayed(this::run,10);
            }
        });
    }
}
