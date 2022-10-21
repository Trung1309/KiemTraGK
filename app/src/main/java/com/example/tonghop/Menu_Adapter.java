package com.example.tonghop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Menu_Adapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<SanPham> list_sanPham;

    public Menu_Adapter(Context context, int layout, List<SanPham> list_sanPham) {
        this.context = context;
        this.layout = layout;
        this.list_sanPham = list_sanPham;
    }

    @Override
    public int getCount() {
        return list_sanPham.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        //ánh xạ
        TextView txt_ten = view.findViewById(R.id.ten_sp);
        TextView txt_tt = view.findViewById(R.id.TT_sp);
        ImageView avata = view.findViewById(R.id.image_sp);
        TextView gia = view.findViewById(R.id.gia_sp);

        //Gán giá trị
        SanPham sanPham = list_sanPham.get(i);
        txt_ten.setText(sanPham.getTen());
        txt_tt.setText(sanPham.getThongTin());
        avata.setImageResource(sanPham.getAvt());
        gia.setText(sanPham.getGia());


        return view;
    }
}
