package com.game.colorroll.actJg;

import static com.game.colorroll.actJg.StartActivityJG.viewModJg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.game.colorroll.R;

public class RulActivityJG extends AppCompatActivity {

    TextView textViewRul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rul_jg);
        textViewRul = findViewById(R.id.textViewRul);
        textViewRul.setText("Сollect as many elements as possible without touching the border");
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), StartActivityJG.class));
        finishAffinity();
        viewModJg.stopMediaJG();
    }
}