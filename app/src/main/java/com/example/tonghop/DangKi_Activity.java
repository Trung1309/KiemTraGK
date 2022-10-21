package com.example.tonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DangKi_Activity extends AppCompatActivity {

    private Button btn_back;
    private EditText name,password,repassword;
    private Button btn_dk;
    private DB_Helper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        AnhXa();
        DB = new DB_Helper(this);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = name.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals("")){
                    Toast.makeText(DangKi_Activity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    if (pass.equals(repass)){
                        Boolean checkuser = DB.checkUsername(user);
                        if (checkuser == false){
                            Boolean insert = DB.insertDATA(user,pass);
                            if (insert == true){
                                Toast.makeText(getApplicationContext(), "Đăng kí tài khoản thành công", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(DangKi_Activity.this, DangNhap_Activity.class);
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(getApplicationContext(), "Đăng kí tài khoản không thành công", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(DangKi_Activity.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }

    private void AnhXa() {
        btn_back = findViewById(R.id.btn_back);
        btn_dk = findViewById(R.id.btn_dk);
        name = findViewById(R.id.txt_name_dk);
        password = findViewById(R.id.txt_pass_dk);
        repassword = findViewById(R.id.txt_cfpass_dk);

    }
}