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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hieu PC
 */
public class BUSUuDai {

    DAOUuDai DAO = new DAOUuDai();

    public ArrayList<DTOUuDai> getlist() throws SQLException, ParseException {
        return DAO.getlist();
    }

    public int adduudai(DTOUuDai i) throws SQLException {
        return DAO.adduudai(i);
    }

    public int updateuudai(DTOUuDai i) throws SQLException {
        return DAO.updateuudai(i);
    }

    public void jtimport(JTable jt, ArrayList<DTOUuDai> list) throws SQLException {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã Ưu đãi");
        model.addColumn("Mốc điểm");
        model.addColumn("Tỉ lệ giảm ( % )");

        for (DTOUuDai i : list) {
            model.addRow(new Object[]{i.getMaUuDai(), i.getMocUuDai(), i.getTiLeGiam()});
        }
        jt.setModel(model);
    }

    public DTOUuDai getud(DTOUuDai i) throws SQLException, ParseException {
        return DAO.getud(i);
    }
}
