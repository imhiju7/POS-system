/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Hieu PC
 */
public class DTONhanVien {
    private int maNhanVien;
    private String tenNhanVien;
    private int maChucVu;
    private int gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String Email;
    private String SDT;
    private int isdelete;
    private Date ngayTao;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    private String img;

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public int getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(int maChucVu) {
        this.maChucVu = maChucVu;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
    public String getStringGioiTinh(){
        String gioitinh = "";
        if(this.gioiTinh == 0){
            gioitinh = "Nữ";
        }
        else{
            gioitinh = "Nam";
        }
        return gioitinh;
    }
    public int getIntGioiTinh(String gioitinh){
        int i = 0;
        if(gioitinh.equals("Nam")){
            i = 1;
        }
        else{
            i = 0;
        }
        return i;
    }   


    public DTONhanVien(){}
    public DTONhanVien(int maNhanVien, String tenNhanVien, int maChucVu, int gioiTinh, Date ngaySinh, String diaChi, String Email, String SDT, int isdelete, Date ngayTao,String img) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.maChucVu = maChucVu;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.Email = Email;
        this.SDT = SDT;
        this.isdelete = isdelete;
        this.ngayTao = ngayTao;
        this.img = img;
    }
}
