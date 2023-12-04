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
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hieu PC
 */
public class BUSChucNang {
    DAOChucNang DAO = new DAOChucNang();
    DAOGroup DAOgr = new DAOGroup();
    public ArrayList<DTOChucNang> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addchucnang(DTOChucNang i) throws SQLException{
        return DAO.addchucnang(i);
    }
    public int updatechucnang(DTOChucNang i) throws SQLException{
        return DAO.updatechucnang(i);
    }
    public ArrayList<DTOChucNang> getlistgroup(int magr) throws SQLException, ParseException{
        return DAO.getlistgroup(magr);
    }
    public void jtimport(JTable jt,ArrayList<DTOChucNang> list) throws SQLException, ParseException{
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã chức năng");
        model.addColumn("Tên chức năng");
        model.addColumn("Nhóm chức năng");
        for(DTOChucNang i: list){
            DTOGroup gr = new DTOGroup();
            gr.setMaGroup(i.getMaGroup());
            gr = DAOgr.getgr(gr);
            model.addRow(new Object[]{i.getMaChucNang(),i.getTenChucNang(),gr.getTenGroup()});
        }
        jt.setModel(model);
    }
    public ArrayList<DTOChucNang> jtexport(JTable jt) throws SQLException, ParseException{
        ArrayList<DTOChucNang> list = new ArrayList<>();
        int size = jt.getRowCount();
        for(int i = 0; i < size; i++){
            DTOChucNang a = new DTOChucNang();
            a.setMaChucNang(Integer.parseInt(jt.getValueAt(i, 0).toString()));
            a = DAO.getcn(a);
            list.add(a);
        }
        return list;
    }
    public ArrayList<DTOChucNang> searchten(ArrayList<DTOChucNang> list, String ten){
        ArrayList<DTOChucNang> result = new ArrayList<>();
        for(DTOChucNang i: list){
            if(i.getTenChucNang().contains(ten)){
                result.add(i);
            }
        }
        return result;
    }
    public void cbimport(JComboBox jcb,ArrayList<DTOGroup> cv){
        jcb.removeAllItems();
        jcb.addItem("Nhóm chức năng");
        for(DTOGroup i: cv){
            jcb.addItem(i.getTenGroup());
        }
    }
    public boolean checktencn(String ten) throws SQLException, ParseException{
        return DAO.checktencn(ten);
    }
    public boolean checktencnedit(String ten,int macn) throws ParseException, SQLException{
        int count = 0;
        ArrayList<DTOChucNang> list = DAO.getlist();
        for(DTOChucNang i: list){
            if(i.getTenChucNang().equals(ten) && i.getMaChucNang() !=macn){
                count++;
            }
        }
        if(count > 0) return false;
        else return true;
    }
    public DTOChucNang getcn(DTOChucNang i) throws SQLException, ParseException{
        return DAO.getcn(i);
    }
}
