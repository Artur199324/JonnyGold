package com.game.colorroll.modJg;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import com.game.colorroll.R;

public class MediaJG {

    Context context;
    MediaPlayer mediaPlayer1;
    MediaPlayer mediaPlayer2;
    MediaPlayer mediaPlayer3;
    int[] mMedia = new int[]{R.raw.jessmithmusicabrightday,R.raw.musiczapsplatbananatree,R.raw.musiczapsplatblugrassbilly};

    public MediaJG(Context context) {
        this.context = context;
    }

    public void mediaPlayCrateMg(int jj){
        switch (jj){
            case 0:
                mediaPlay1(context);
                break;
            case 1:
                mediaPlay2(context);
                break;
            case 2:
                mediaPlay3(context);
                break;
        }
    }

    public void mediaPlayStopMG(int jj){
        Log.d("weq","aa");
        switch (jj){
            case 0:
                mediaStop1();
                Log.d("weq","55");
                break;
            case 1:
                mediaStop2();
                Log.d("weq","66");
                break;
            case 2:
                mediaStop3();
                Log.d("weq","77");
                break;
        }
    }

    public void mediaPlay1(Context context){
        mediaPlayer1  = MediaPlayer.create(context, mMedia[0]);
        mediaPlayer1.setLooping(true);
        mediaPlayer1.start();
    }

    public void mediaPlay2(Context context){
        mediaPlayer2  = MediaPlayer.create(context, mMedia[1]);
        mediaPlayer2.setLooping(true);
        mediaPlayer2.start();
    }

    public void mediaPlay3(Context context){
        mediaPlayer3  = MediaPlayer.create(context, mMedia[2]);
        mediaPlayer3.setLooping(true);
        mediaPlayer3.start();
    }

    public void mediaStop1(){
        mediaPlayer1.stop();
    }

    public void mediaStop2(){
        mediaPlayer2.stop();
        Log.d("weq","aa");
    }
    public void mediaStop3(){
        mediaPlayer3.stop();
    }
}
