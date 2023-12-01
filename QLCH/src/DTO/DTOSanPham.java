/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class DTOSanPham {

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(Date ngayThem) {
        this.ngayThem = ngayThem;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getIshidden() {
        return ishidden;
    }

    public void setIshidden(int ishidden) {
        this.ishidden = ishidden;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }
    public DTOSanPham(){}
    public DTOSanPham(int maSanPham, String tenSanPham, double giaBan, int soLuong, Date ngayThem, String img, int ishidden, int isdelete) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.ngayThem = ngayThem;
        this.img = img;
        this.ishidden = ishidden;
        this.isdelete = isdelete;
    }
    
    private int maSanPham;
    private String tenSanPham;
    private double giaBan;
    private int soLuong;
    private Date ngayThem;
    private String img;
    private int ishidden;
    private int isdelete;
}
