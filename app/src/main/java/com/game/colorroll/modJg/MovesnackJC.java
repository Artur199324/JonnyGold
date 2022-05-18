package com.game.colorroll.modJg;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.game.colorroll.R;

import java.util.ArrayList;

public class MovesnackJC {

    private int w;
    private int h;
    private ImageView imgSnake;
    boolean t = false;
    boolean b = false;
    boolean r = true;
    boolean l = false;
    boolean st = false;
    TextView textViewGO,textViewRE;
    int aa = 0;
    Handler handler;
    ArrayList<ImageView> arrayListJg;
    MediaJG mediaJG;

    public MovesnackJC(int w, int h, ImageView imageView) {
        this.w = w;
        this.h = h;
        this.imgSnake = imageView;
        handler = new Handler();
    }

    public void setMediaJG(MediaJG mediaJG) {
        this.mediaJG = mediaJG;
    }

    public ArrayList<ImageView> getArrayListJg() {
        return arrayListJg;
    }

    public void setArrayListJg(ArrayList<ImageView> arrayListJg) {
        this.arrayListJg = arrayListJg;

    }

    public boolean isSt() {
        return st;
    }

    public TextView getTextViewGO() {
        return textViewGO;
    }

    public void setTextViewGO(TextView textViewGO) {
        this.textViewGO = textViewGO;
    }

    public TextView getTextViewRE() {
        return textViewRE;
    }

    public void setTextViewRE(TextView textViewRE) {
        this.textViewRE = textViewRE;
    }

    public void setSt(boolean st) {
        this.st = st;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public ImageView getImgSnake() {
        return imgSnake;
    }

    public void setImgSnake(ImageView imgSnake) {
        this.imgSnake = imgSnake;
    }

    public boolean isT() {
        return t;
    }

    public void setT(boolean t) {
        this.t = t;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public boolean isR() {
        return r;
    }

    public void setR(boolean r) {
        this.r = r;
    }

    public boolean isL() {
        return l;
    }

    public void setL(boolean l) {
        this.l = l;
    }

    public void moveJGR(int jj) {

        handler.post(new Runnable() {
            @Override
            public void run() {
                if (isR()) {
                    imgSnake.setX(imgSnake.getX() + 5);
                    if (imgSnake.getX() > w) {
                       setR(false);
                       setL(false);
                       setT(false);
                       setB(false);
                       textViewGO.setVisibility(View.VISIBLE);
                       textViewRE.setVisibility(View.VISIBLE);
                       mediaJG.mediaPlayStopMG(jj);
                       imgSnake.setVisibility(View.INVISIBLE);
                        aa =0;
                        if (st){
                            for (int i = 0; i < arrayListJg.size(); i++) {
                                ImageView imageView = arrayListJg.get(i);
                                imageView.setVisibility(View.INVISIBLE);
                                arrayListJg.remove(i);
                            }
                        }
                        st = false;
                    }

                    aa = imgSnake.getWidth();
                    if (st){
                    for (int i = 0; i < arrayListJg.size(); i++) {
                        ImageView imageView = arrayListJg.get(i);


                        aa += imgSnake.getWidth();

                        imageView.setY(imgSnake.getY());
                        imageView.setX(imgSnake.getX() - aa);
                        if (i == arrayListJg.size() - 1) {
                            aa = imgSnake.getWidth();
                        }
                    }}


                    handler.postDelayed(this::run, 10);
                } else {
                    setR(false);
                }

            }
        });

    }

    public void moveJGL(int jj) {

        handler.post(new Runnable() {
            @Override
            public void run() {
                if (isL()) {
                    imgSnake.setX(imgSnake.getX() - 5);
                    if (imgSnake.getX() < 0) {
                       setL(false);
                        aa =0;
                        textViewGO.setVisibility(View.VISIBLE);
                        textViewRE.setVisibility(View.VISIBLE);
                        imgSnake.setVisibility(View.INVISIBLE);
                        setR(false);
                        setL(false);
                        setT(false);
                        setB(false);
                        mediaJG.mediaPlayStopMG(jj);
                        if (st){
                            for (int i = 0; i < arrayListJg.size(); i++) {
                                ImageView imageView = arrayListJg.get(i);
                                imageView.setVisibility(View.INVISIBLE);
                                arrayListJg.remove(i);
                            }
                        }
                        st = false;
                    }

                    aa = imgSnake.getWidth();
                    if (st){
                    for (int i = 0; i < arrayListJg.size(); i++) {
                        ImageView imageView = arrayListJg.get(i);


                        aa += imgSnake.getWidth();


                        imageView.setY(imgSnake.getY());
                        imageView.setX(imgSnake.getX() + aa);
                        if (i == arrayListJg.size() - 1) {
                            aa = imgSnake.getWidth();
                        }
                    }}
                    handler.postDelayed(this::run, 10);
                } else {
                    setL(false);
                }

            }
        });
    }

    public void moveJGT(int jj) {

        handler.post(new Runnable() {
            @Override
            public void run() {
                if (isT()) {
                    imgSnake.setY(imgSnake.getY() - 5);
                    if (imgSnake.getY() < 0) {
                       setT(false);
                        setR(false);
                        setL(false);
                        setT(false);
                        setB(false);
                        aa =0;
                        textViewGO.setVisibility(View.VISIBLE);
                        textViewRE.setVisibility(View.VISIBLE);
                        imgSnake.setVisibility(View.INVISIBLE);
                        mediaJG.mediaPlayStopMG(jj);
                        if (st){
                            for (int i = 0; i < arrayListJg.size(); i++) {
                                ImageView imageView = arrayListJg.get(i);
                                imageView.setVisibility(View.INVISIBLE);
                                arrayListJg.remove(i);
                            }
                        }
                        st = false;
                    }
                    aa = imgSnake.getWidth();

                    if (st){
                    for (int i = 0; i < arrayListJg.size(); i++) {
                        ImageView imageView = arrayListJg.get(i);


                        aa += imgSnake.getWidth();

                        imageView.setY(imgSnake.getY() + aa);
                        imageView.setX(imgSnake.getX());
                        if (i == arrayListJg.size() - 1) {
                            aa = imgSnake.getWidth();
                        }
                    }}
                    handler.postDelayed(this::run, 10);
                } else {
                    setT(false);
                }

            }
        });
    }


    public void moveJGB(int jj) {

        handler.post(new Runnable() {
            @Override
            public void run() {
                if (isB()) {
                    imgSnake.setY(imgSnake.getY() + 5);
                    if (imgSnake.getY() > h) {
                        setB(false);
                        setR(false);
                        setL(false);
                        setT(false);
                        setB(false);
                        aa =0;
                        textViewGO.setVisibility(View.VISIBLE);
                        textViewRE.setVisibility(View.VISIBLE);
                        imgSnake.setVisibility(View.INVISIBLE);
                        mediaJG.mediaPlayStopMG(jj);
                        if (st){
                            for (int i = 0; i < arrayListJg.size(); i++) {
                                ImageView imageView = arrayListJg.get(i);
                                imageView.setVisibility(View.INVISIBLE);
                                arrayListJg.remove(i);
                            }
                        }
                        st = false;
                    }

                    if (st){
                    for (int i = 0; i < arrayListJg.size(); i++) {
                        ImageView imageView = arrayListJg.get(i);

                        aa += imgSnake.getWidth();

                        imageView.setY(imgSnake.getY() - aa);
                        imageView.setX(imgSnake.getX());
                        if (i == arrayListJg.size() - 1) {
                            aa = imgSnake.getWidth();
                        }

                    }}
                    handler.postDelayed(this::run, 10);
                } else {
                    setB(false);
                }

            }
        });
    }
}
