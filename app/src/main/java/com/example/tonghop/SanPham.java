package com.example.tonghop;

public class SanPham {
    private String ten,thongTin;
    private String gia;
    private int avt;

    public SanPham(String ten, String thongTin, String gia, int avt) {
        this.ten = ten;
        this.thongTin = thongTin;
        this.gia = gia;
        this.avt = avt;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public int getAvt() {
        return avt;
    }

    public void setAvt(int avt) {
        this.avt = avt;
    }
}
