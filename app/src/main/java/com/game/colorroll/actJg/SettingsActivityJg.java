package com.game.colorroll.actJg;

import static com.game.colorroll.actJg.GameActivityJg.dj;
import static com.game.colorroll.actJg.StartActivityJG.viewModJg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.game.colorroll.R;

public class SettingsActivityJg extends AppCompatActivity {

    CheckBox checkBoxS1, checkBoxS2, checkBoxS3;
    ImageView imageViewP1, imageViewP2, imageViewP3;
    ImageView imageViewS1, imageViewS2, imageViewS3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_jg);
        getWindow().addFlags(1024);
        checkBoxS1 = findViewById(R.id.checkBoxS1);
        checkBoxS2 = findViewById(R.id.checkBoxS2);
        checkBoxS3 = findViewById(R.id.checkBoxS3);
        imageViewP1 = findViewById(R.id.imageViewP1);
        imageViewP2 = findViewById(R.id.imageViewP2);
        imageViewP3 = findViewById(R.id.imageViewP3);
        imageViewS1 = findViewById(R.id.imageViewS1);
        imageViewS2 = findViewById(R.id.imageViewS2);
        imageViewS3 = findViewById(R.id.imageViewS3);

        if (viewModJg.getSaveIntJG() == 0) {
            checkBoxS1.setChecked(true);
        }
        if (viewModJg.getSaveIntJG() == 1) {
            checkBoxS2.setChecked(true);

        }
        if (viewModJg.getSaveIntJG() == 2) {
            checkBoxS3.setChecked(true);

        }

        imageViewP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModJg.mediaPlay1(SettingsActivityJg.this);
            }
        });

        imageViewP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModJg.mediaPlay2(SettingsActivityJg.this);
            }
        });
        imageViewP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModJg.mediaPlay3(SettingsActivityJg.this);
            }
        });

        imageViewS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModJg.mediaStop1();
            }
        });
        imageViewS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModJg.mediaStop2();
            }
        });
        imageViewS3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModJg.mediaStop3();
            }
        });

        checkBoxS1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                checkBoxS2.setChecked(false);
                checkBoxS3.setChecked(false);
                int j = 0;
                viewModJg.saveIntJG(j);
            }
        });

        checkBoxS2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                checkBoxS1.setChecked(false);
                checkBoxS3.setChecked(false);
                int j = 1;
                viewModJg.saveIntJG(j);
            }
        });

        checkBoxS3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                checkBoxS2.setChecked(false);
                checkBoxS1.setChecked(false);
                int j = 2;
                viewModJg.saveIntJG(j);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (dj) {
            startActivity(new Intent(getApplicationContext(), GameActivityJg.class));
            finishAffinity();
            dj = false;
            viewModJg.stopMediaJG();
        } else {
            startActivity(new Intent(getApplicationContext(), StartActivityJG.class));
            finishAffinity();
            viewModJg.stopMediaJG();
        }
    }
}