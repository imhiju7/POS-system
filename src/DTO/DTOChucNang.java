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

    private int maChucNang;
    private String tenChucNang;
    private int isDelete;

    public DTOChucNang() {
    }

    public DTOChucNang(String tenChucNang, int isDelete) {
        this.tenChucNang = tenChucNang;
        this.isDelete = isDelete;
    }

    public DTOChucNang(int maChucNang, String tenChucNang, int isDelete) {
        this.maChucNang = maChucNang;
        this.tenChucNang = tenChucNang;
        this.isDelete = isDelete;
    }

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

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
