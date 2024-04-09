/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author buile
 */
public class DTOPhanQuyen {

    private int maPhanQuyen;
    private int maChucVu;
    private int maChucNang;

    public int getMaPhanQuyen() {
        return maPhanQuyen;
    }

    public void setMaPhanQuyen(int maPhanQuyen) {
        this.maPhanQuyen = maPhanQuyen;
    }

    public int getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(int maChucVu) {
        this.maChucVu = maChucVu;
    }

    public int getMaChucNang() {
        return maChucNang;
    }

    public void setMaChucNang(int maChucNang) {
        this.maChucNang = maChucNang;
    }
    public DTOPhanQuyen(){}
    public DTOPhanQuyen(int maPhanQuyen, int maChucVu, int maChucNang) {
        this.maPhanQuyen = maPhanQuyen;
        this.maChucVu = maChucVu;
        this.maChucNang = maChucNang;
    }

}
