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
public class BUSGroup {
    DAOGroup DAOgr = new DAOGroup();
    public ArrayList<DTOGroup> getlist() throws SQLException, ParseException{
        return DAOgr.getlist();
    }
    public int addgroup(DTOGroup i) throws SQLException{
        return DAOgr.addgroup(i);
    }
    public int updategroup(DTOGroup i) throws SQLException{
        return DAOgr.updategroup(i);
    }
    public void jtimport(JTable jt,ArrayList<DTOGroup> list) throws SQLException, ParseException{
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã nhóm chức năng");
        model.addColumn("Tên nhóm chức năng");
        
        for(DTOGroup i: list){
            model.addRow(new Object[]{i.getMaGroup(),i.getTenGroup()});
        }
        jt.setModel(model);
    }
    public ArrayList<DTOGroup> jtexport(JTable jt) throws SQLException, ParseException{
        ArrayList<DTOGroup> list = new ArrayList<>();
        int size = jt.getRowCount();
        for(int i = 0; i < size; i++){
            DTOGroup a = new DTOGroup();
            a.setMaGroup(Integer.parseInt(jt.getValueAt(i, 0).toString()));
            a = DAOgr.getgr(a);
            list.add(a);
        }
        return list;
    }
    public ArrayList<DTOGroup> searchten(ArrayList<DTOGroup> list, String ten){
        ArrayList<DTOGroup> result = new ArrayList<>();
        for(DTOGroup i: list){
            if(i.getTenGroup().contains(ten)){
                result.add(i);
            }
        }
        return result;
    }
    public boolean checktengr(String ten) throws SQLException, ParseException{
        return DAOgr.checktengr(ten);
    }
    public boolean checktengredit(String ten,int macn) throws ParseException, SQLException{
        int count = 0;
        ArrayList<DTOGroup> list = DAOgr.getlist();
        for(DTOGroup i: list){
            if(i.getTenGroup().equals(ten) && i.getMaGroup() !=macn){
                count++;
            }
        }
        if(count > 0) return false;
        else return true;
    }
    public DTOGroup getgr(DTOGroup i) throws SQLException, ParseException{
        return DAOgr.getgr(i);
    }
    public DTOGroup getgrbyten(DTOGroup i) throws SQLException, ParseException{
        return DAOgr.getgr(i);
    }
}
