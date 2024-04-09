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
public class BUSUuDai {
    DAOUuDai DAO = new DAOUuDai();
    public ArrayList<DTOUuDai> getlist() throws SQLException, ParseException{
        return DAO.getlist();
    }
    public int adduudai(DTOUuDai i) throws SQLException{
        return DAO.adduudai(i);
    }
    public int updateuudai(DTOUuDai i) throws SQLException{
        return DAO.updateuudai(i);
    }
    public void jtimport(JTable jt,ArrayList<DTOUuDai> list) throws SQLException{
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã Ưu đãi");
        model.addColumn("Mốc điểm");
        model.addColumn("Tỉ lệ giảm ( % )");

        
        for(DTOUuDai i: list){
            model.addRow(new Object[]{i.getMaUuDai(),i.getMocUuDai(),i.getTiLeGiam()});
        }
        jt.setModel(model);
    }
    public DTOUuDai getud(DTOUuDai i) throws SQLException, ParseException{
        return DAO.getud(i);
    }
    public boolean checkdiem(int moc,int tile){
        boolean key = false;
        try {
            ArrayList<DTOUuDai> list = getlist();
            DTOUuDai max = new DTOUuDai();
            DTOUuDai min = new DTOUuDai();
            DTOUuDai truoc = new DTOUuDai();
            DTOUuDai sau = new DTOUuDai();
            int count = 0;
            for(DTOUuDai i: list){
                if(i.getMocUuDai() > moc){
                    if(count != 0){
                        sau.setTiLeGiam(i.getTiLeGiam());
                    }
                    else{
                        min.setTiLeGiam(i.getTiLeGiam());
                    }
                    break;
                }
                else{
                    if(count < list.size()-1){
                        truoc.setTiLeGiam(i.getTiLeGiam());
                        count++;
                    }
                    else{
                        max.setTiLeGiam(i.getTiLeGiam());
                        break;
                    }
                }
            }
            if(max.getTiLeGiam() > 0){
                if(max.getTiLeGiam() < tile){
                    key = true;
                }
                else{
                    key = false;
                }
            }
            else if(min.getTiLeGiam() > 0){
                if(min.getTiLeGiam() > tile){
                    key = true;
                }
                else{
                    key = false;
                }
            }
            else{
                if(sau.getTiLeGiam() >= tile && truoc.getTiLeGiam() <= tile){
                    key = true;
                }
                else{
                    key = false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BUSUuDai.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(BUSUuDai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }
    public DTOUuDai setudbydiem(int diem) throws SQLException, ParseException{
        ArrayList<DTOUuDai> list = getlist();
        DTOUuDai ud = new DTOUuDai();
        for(DTOUuDai i : list){
            if(diem > i.getMocUuDai()){
                ud = i;
            }
            else{
                break;
            }
        }
        return ud;
    }
}
