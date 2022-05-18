package com.game.colorroll.modJg;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.game.colorroll.R;

import java.util.Random;

public class CreationElementJg {

    int w;
    int h;
    ImageView imageViewElem;


    public CreationElementJg(int w, int h, ImageView imageViewElem) {
        this.w = w;
        this.h = h;
        this.imageViewElem = imageViewElem;
    }

    public void createElementJg() {
        imageViewElem.setX(rndjg(0, w - (imageViewElem.getWidth()+ 200)));
        imageViewElem.setY(rndjg(0, h - (imageViewElem.getHeight()+200)));
    }

    public void randomImageJG() {
        Random random = new Random();
        switch (random.nextInt(2)) {
            case 0:
                imageViewElem.setImageResource(R.drawable.ttt2);
                break;
            case 1:
                imageViewElem.setImageResource(R.drawable.ttt3);
                break;
        }
    }

    public static int rndjg(int minJg, int maxJG) {
        maxJG -= minJg;
        return (int) (Math.random() * ++maxJG) + minJg;
    }
}
