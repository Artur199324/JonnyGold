package com.game.colorroll.actJg;

import static com.game.colorroll.actJg.StartActivityJG.viewModJg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.game.colorroll.R;

public class RecordActivityJG extends AppCompatActivity {

    TextView textViewRe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_jg);
        textViewRe = findViewById(R.id.textViewRe);
        textViewRe.setText(viewModJg.getRecJG());
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), StartActivityJG.class));
        finishAffinity();
    }
}