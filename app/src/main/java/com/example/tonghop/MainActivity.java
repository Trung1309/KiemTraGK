package com.example.tonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ProgressBar pg;
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        pg = findViewById(R.id.pr_Loadding);
        txt = findViewById(R.id.txt_phanTram);
        pg.setMax(100);
        pog();
    }

    private void pog() {
        Progress_Animation pr = new Progress_Animation(MainActivity.this,pg,txt,0f,100f);
        pr.setDuration(2000);
        pg.setAnimation(pr);
    }
}