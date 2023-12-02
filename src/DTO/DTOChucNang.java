/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Hieu PC
 */
public class DTOChucNang {

    public int getMaChucNang() {
        return maChucNang;
    }

    public void setMaChucNang(int maChucNang) {
        this.maChucNang = maChucNang;
    }

    public String getTenChucNang() {
        return tenChucNang;
    }

    public void setTenChucNang(String tenChucNang) {
        this.tenChucNang = tenChucNang;
    }
    public DTOChucNang(){}

    public DTOChucNang(int maChucNang, String tenChucNang, int maGroup, int isHidden) {
        this.maChucNang = maChucNang;
        this.tenChucNang = tenChucNang;
        this.maGroup = maGroup;
        this.isHidden = isHidden;
    }
    private int maChucNang;
    private String tenChucNang;
    private int maGroup;
    private int isHidden;
    public int getMaGroup() {
        return maGroup;
    }

    public void setMaGroup(int maGroup) {
        this.maGroup = maGroup;
    }




    public int getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(int isHidden) {
        this.isHidden = isHidden;
    }
}
