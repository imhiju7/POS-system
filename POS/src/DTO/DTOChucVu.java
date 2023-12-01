/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author buile
 */
public class DTOChucVu {
    public DTOChucVu(){}
    public DTOChucVu(int maChucVu, String tenChucVu,int isHidden) {
        this.maChucVu = maChucVu;
        this.tenChucVu = tenChucVu;
        this.isHidden = isHidden;
    }

    public int getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(int maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    private int maChucVu;
    private String tenChucVu;

    public int getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(int isHidden) {
        this.isHidden = isHidden;
    }
    private int isHidden;
}
