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
}
