/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Hieu PC
 */
public class Connect {
    public Connect(){
        
    }
    public static Connection connection(){
        String url = "jdbc:mysql://localhost:3306/qlcuahangtienloi";
        String username = "root";
        String password = "ToilaHieuday7";
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return con;
    }
}
