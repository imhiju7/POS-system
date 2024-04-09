/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.*;
import DTO.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Hieu PC
 */
public class BUSPhanQuyen {
    DAOPhanQuyen DAO = new DAOPhanQuyen();
    DAOChucVu DAOcv = new DAOChucVu();
    DAOChucNang DAOcn = new DAOChucNang();
    public ArrayList<DTOPhanQuyen> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addphanquyen(DTOPhanQuyen i) throws SQLException{
        return DAO.addphanquyen(i);
    }
    public int updatephanquyen(DTOPhanQuyen i) throws SQLException{
        return DAO.updatephanquyen(i);
    }
    public void jtimport(JTable jt,ArrayList<DTOPhanQuyen> list) throws SQLException, ParseException{
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã phân quyền");
        model.addColumn("Tên chức vụ");
        model.addColumn("Tên chức năng");
        
        for(DTOPhanQuyen i: list){
            DTOChucVu cv = new DTOChucVu();
            cv.setMaChucVu(i.getMaChucVu());
            cv = DAOcv.getcv(cv);
            DTOChucNang cn = new DTOChucNang();
            cn.setMaChucNang(i.getMaChucNang());
            cn = DAOcn.getcn(cn);
            model.addRow(new Object[]{i.getMaPhanQuyen(),cv.getTenChucVu(),cn.getTenChucNang()});
        }
        jt.setModel(model);
    }
    public ArrayList<DTOPhanQuyen> jtexport(JTable jt) throws SQLException{
        ArrayList<DTOPhanQuyen> list = new ArrayList<>();
        int size = jt.getRowCount();
        for(int i = 0; i < size; i++){
            DTOPhanQuyen a = new DTOPhanQuyen();
            a.setMaPhanQuyen(Integer.parseInt(jt.getValueAt(i, 0).toString()));
            a = DAO.getpq(a);
            list.add(a);
        }
        return list;
    }
    public void cbcvimport(JComboBox jcb,ArrayList<DTOChucVu> list){
        jcb.removeAllItems();
        jcb.addItem("Chức vụ");
        for(DTOChucVu i: list){
            jcb.addItem(i.getTenChucVu());
        }
    }
    public void cbcnimport(JComboBox jcb,ArrayList<DTOChucNang> list){
        jcb.removeAllItems();
        jcb.addItem("Chức năng");
        for(DTOChucNang i: list){
            jcb.addItem(i.getTenChucNang());
        }
    }
    public ArrayList<DTOPhanQuyen> listpqcv(DTOPhanQuyen i) throws SQLException{
        return DAO.getlistcbcv(i);
    }
    public boolean checkpq(int macv,int macn) throws SQLException{
        return DAO.checkpq(macv, macn);
    }
    public boolean checkpqedit(int mapq,int macv,int macn) throws SQLException{
        return DAO.checkpqedit(mapq, macv, macn);
    }
    public int deletephanquyen(DTOPhanQuyen i) throws SQLException{
        return DAO.deletephanquyen(i);
    }
}
