package com.example.tonghop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DanhSach_Activity extends AppCompatActivity {
    ListView listView;
    Menu_Adapter adapter;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        String[] name = {"Cua Hoàng Đế","Tôm Hùm Hấp","Mực Hấp","Tôm Sú Sốt Thái","Mực Nướng","Cá kho",
                "Cua Hoàng Đế","Tôm Hùm Hấp"};
        int[] image = {R.drawable.cuahoangde,R.drawable.tomhum,R.drawable.muchap,R.drawable.tomtai,R.drawable.mucnuong,
                R.drawable.cakho,R.drawable.cuahoangde,R.drawable.tomhum};
        String[] moTa = {"Cua AlatKa 3kg" , "Tôm AlatKa 2kg","Mực 1kg","Tôm Sú 1kg","Mực lá 1kg","Cá ngừ",
                "Cua AlatKa 3kg" , "Tôm AlatKa 2kg"};
        String[] gia = {"200$","200$","30$","70$","70$","10$","200$","200$"};

        ArrayList<SanPham> ArrayThucAn = new ArrayList<>();
        for(int i = 0;i < image.length ;i++){
            SanPham sp = new SanPham(name[i],moTa[i],gia[i],image[i]);
            ArrayThucAn.add(sp);
        }
        listView = findViewById(R.id.listMenu);
        btn_back = findViewById(R.id.btn_back_lv);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        adapter = new Menu_Adapter(this,R.layout.dong_menu,ArrayThucAn);
        listView.setAdapter(adapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DanhSach_Activity.this, SanPham_Activity.class);
                intent.putExtra("name",name[i]);
                intent.putExtra("moTa", moTa[i]);
                intent.putExtra("gia", gia[i]);
                intent.putExtra("image",image[i]);
                startActivity(intent);

            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int item = i;
                AlertDialog.Builder builder = new AlertDialog.Builder(DanhSach_Activity.this);
                builder.setMessage("Bạn có xoá không ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ArrayThucAn.remove(item);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
    }
}