package DTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hieu PC
 */
public class DTOPhanLoai {

    public DTOPhanLoai(int maPhanLoai, String tenPhanLoai) {
        this.maPhanLoai = maPhanLoai;
        this.tenPhanLoai = tenPhanLoai;
    }
    public DTOPhanLoai(){}
    public int getMaPhanLoai() {
        return maPhanLoai;
    }

    public void setMaPhanLoai(int maPhanLoai) {
        this.maPhanLoai = maPhanLoai;
    }

    public String getTenPhanLoai() {
        return tenPhanLoai;
    }

    public void setTenPhanLoai(String tenPhanLoai) {
        this.tenPhanLoai = tenPhanLoai;
    }
    private int maPhanLoai;
    private String tenPhanLoai;
}
