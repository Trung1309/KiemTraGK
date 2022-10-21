package com.example.tonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SanPham_Activity extends AppCompatActivity {

    private Button btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham);
        btn_back = findViewById(R.id.btn_sp_back);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        Intent intent = getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            String moTa = intent.getStringExtra("moTa");
            String Gia = intent.getStringExtra("gia");
            int img = intent.getIntExtra("image", R.drawable.cuahoangde);

            // Anh xa
            TextView ten = findViewById(R.id.ten);
            TextView tt = findViewById(R.id.tt);
            TextView gia = findViewById(R.id.gia);
            ImageView avt = findViewById(R.id.avt);

            // Hien thi chu

            ten.setText(name);
            tt.setText(moTa);
            gia.setText(Gia);
            avt.setImageResource(img);


        }
    }
}