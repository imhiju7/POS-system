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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Hieu PC
 */
public class BUSTichDiem {
    DAOTichDiem DAO = new DAOTichDiem();
    public ArrayList<DTOTichDiem> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int addtichdiem(DTOTichDiem i) throws SQLException{
        return DAO.addtichdiem(i);
    }
    public int updatetichdiem(DTOTichDiem i) throws SQLException{
        return DAO.updatetichdiem(i);
    }
    public DTOTichDiem gettd(DTOTichDiem i) throws SQLException{
        return DAO.gettd(i);
    }
    public void jtimport(JTable jt,ArrayList<DTOTichDiem> list) throws SQLException{
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã Tích điểm");
        model.addColumn("Mốc Tiền");
        model.addColumn("Điểm");
        for(DTOTichDiem i: list){
            model.addRow(new Object[]{i.getMaTichDiem(),i.getTien(),i.getDiemTichLuy()});
        }
        jt.setModel(model);
    }
    public boolean checkdiem(int diem,double tien){
        boolean key = false;
        try {
            ArrayList<DTOTichDiem> list = getlist();
            DTOTichDiem max = new DTOTichDiem();
            DTOTichDiem min = new DTOTichDiem();
            DTOTichDiem truoc = new DTOTichDiem();
            DTOTichDiem sau = new DTOTichDiem();
            int count = 0;
            for(DTOTichDiem i: list){
                if(i.getTien() > tien){
                    if(count != 0){
                        sau.setDiemTichLuy(i.getDiemTichLuy());
                    }
                    else{
                        min.setDiemTichLuy(i.getDiemTichLuy());
                    }
                    break;
                }
                else{
                    if(count < list.size()-1){
                        truoc.setDiemTichLuy(i.getDiemTichLuy());
                        count++;
                    }
                    else{
                        max.setDiemTichLuy(i.getDiemTichLuy());
                        break;
                    }
                }
            }
                
            if(max.getDiemTichLuy() > 0){
                if(max.getDiemTichLuy() < diem){
                    key = true;
                }
                else{
                    key = false;
                }
            }
            else if(min.getDiemTichLuy() > 0){
                if(min.getDiemTichLuy() > diem){
                    key = true;
                }
                else{
                    key = false;
                }
            }
            else{
                if(sau.getDiemTichLuy() >= diem && truoc.getDiemTichLuy() <= diem){
                    key = true;
                }
                else{
                    key = false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BUSTichDiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(BUSTichDiem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }
    public DTOTichDiem gettdbytien(double tien) throws SQLException, ParseException{
        ArrayList<DTOTichDiem> list = DAO.getlist();
        DTOTichDiem td = new DTOTichDiem();
        for(DTOTichDiem i : list){
            if(tien > i.getTien()){
                td = i;
            }
            else{
                break;
            }
        }
        return td;
    }
}
