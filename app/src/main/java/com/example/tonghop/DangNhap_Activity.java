package com.example.tonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DangNhap_Activity extends AppCompatActivity {

    private TextView tv_dk;
    private EditText txt_name, txt_pass;
    private Button btn_dn;
    private DB_Helper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        tv_dk = findViewById(R.id.tv_dk);
        txt_name = findViewById(R.id.txt_name);
        txt_pass = findViewById(R.id.txt_pass);
        btn_dn = findViewById(R.id.btn_dn);
        DB = new DB_Helper(this);
        
        btn_dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txt_name.getText().toString();
                String pass = txt_pass.getText().toString();

                if (name.equals("") || pass.equals("")){
                    Toast.makeText(DangNhap_Activity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkuserpass = DB.checkUsernamePass(name,pass);
                    if (checkuserpass == true){
                        Toast.makeText(DangNhap_Activity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),Home_Activity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "Sai tài khoản mật khẩu", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        tv_dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangNhap_Activity.this, DangKi_Activity.class);
                startActivity(intent);
            }
        });
    }
}