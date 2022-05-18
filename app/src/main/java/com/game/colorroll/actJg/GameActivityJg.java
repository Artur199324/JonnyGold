package com.game.colorroll.actJg;

import static com.game.colorroll.actJg.StartActivityJG.viewModJg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.game.colorroll.R;
import com.game.colorroll.modJg.OnSwipeTouchListenerJg;
import com.game.colorroll.viewmodJg.ViewModJg;

import java.util.ArrayList;

public class GameActivityJg extends AppCompatActivity {


    private ImageView imgSnake, imageViewSeting;
    private ConstraintLayout consAj;
    private Display display;
    private ArrayList<ImageView> arrayListJg;
    private TextView textViewGO, textViewRE, textViewPoi;
    private int count = 0;
    public static boolean dj = false;

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), StartActivityJG.class));
        finishAffinity();
        viewModJg.stopMediaJG();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(1024);


        imgSnake = findViewById(R.id.imgSnake);
        consAj = findViewById(R.id.consAj);
        textViewGO = findViewById(R.id.textViewGO);
        textViewRE = findViewById(R.id.textViewRE);
        textViewPoi = findViewById(R.id.textViewPoi);
        imageViewSeting = findViewById(R.id.imageViewSeting);
        display = getWindowManager().getDefaultDisplay();
        viewModJg.moveJk(display, imgSnake);
        arrayListJg = new ArrayList<>();
        creationElementJg();
        viewModJg.visibleJg(textViewGO, textViewRE);
        viewModJg.media(this);
        imageViewSeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SettingsActivityJg.class));
                finishAffinity();
                dj = true;
            }
        });
        textViewRE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GameActivityJg.class));
                finishAffinity();

                viewModJg.stopMediaJG();
            }
        });
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrayListJg.size(); i++) {
                    ImageView imageView = arrayListJg.get(i);
                    Rect myViewRect = new Rect();
                    imageView.getHitRect(myViewRect);

                    Rect otherViewRect1 = new Rect();
                    imgSnake.getHitRect(otherViewRect1);


                    if (Rect.intersects(myViewRect, otherViewRect1)) {
                        viewModJg.jgj(imageView);
                        creationElementJg();
                        viewModJg.gg();
                        count++;
                        textViewPoi.setText(count + "");
                        viewModJg.saveRecJG(count+"");
                    }


                }

                handler.postDelayed(this::run, 10);
            }
        });


        consAj.setOnTouchListener(new OnSwipeTouchListenerJg(GameActivityJg.this) {
            public void onSwipeTop() {

                viewModJg.moveT();
            }

            public void onSwipeRight() {

                viewModJg.moveR();
            }

            public void onSwipeLeft() {

                viewModJg.moveL();
            }

            public void onSwipeBottom() {

                viewModJg.moveB();
            }

        });
    }

    public void creationElementJg() {
        ImageView imageViewElem = new ImageView(this);
        ConstraintLayout.LayoutParams constraintsElem = new ConstraintLayout.LayoutParams(display.getWidth() / 10, display.getWidth() / 10);
        consAj.addView(imageViewElem);
        imageViewElem.setLayoutParams(constraintsElem);
        viewModJg.crElement(display, imageViewElem);
        arrayListJg.add(imageViewElem);
    }


}