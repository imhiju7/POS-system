/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Hieu PC
 */
public class DTOKhachHang {
    public DTOKhachHang(){}
    public DTOKhachHang(int maKhachHang, String tenKhachHang, String SDT, int diemTichLuy, int maUuDai,int isBlock) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.SDT = SDT;
        this.diemTichLuy = diemTichLuy;
        this.maUuDai = maUuDai;
        this.isBlock = isBlock;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public int getMaUuDai() {
        return maUuDai;
    }

    public void setMaUuDai(int maUuDai) {
        this.maUuDai = maUuDai;
    }
    
    private int maKhachHang;
    private String tenKhachHang;
    private String SDT;
    private int diemTichLuy;
    private int maUuDai;

    public int getIsBlock() {
        return isBlock;
    }

    public void setIsBlock(int isBlock) {
        this.isBlock = isBlock;
    }
    private int isBlock;
}
