/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hallow
 */
public class ConnectionDB {

    Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Connection connectData(String dataname) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=" + dataname;
            con = DriverManager.getConnection(url, "sa", "123");
        } catch (Exception e) {

        }
        return con;
    }
    
    public boolean checkLogin(String username, String password) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-0RMJURM\\HTP:1433;databaseName=Ass_java4";
            con = DriverManager.getConnection(url, "sa", "123");
            String sql = "Select * from Login where username='?' and password='?'";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            boolean result = rs.next();
            rs.close();
            stm.close();
            con.close();
            if (result) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

     public boolean insert(String Tensp, String Gia,String Image ) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-0RMJURM\\HTP:1433;databaseName=Ass_java4";
            con = DriverManager.getConnection(url, "sa", "123");
            String sql = "Insert into Product(nameproduct,price,image)" + "Values(?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(2, Tensp);
            stm.setString(3, Gia);
            stm.setString(4, Image);
            int result = stm.executeUpdate();
            stm.close();
            con.close();
            if (result > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
     public boolean delete(String Id, String Tensp) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=shop;instanceName=SQL2005";
            con = DriverManager.getConnection(url, "sa", "123");
            String sql = "Delete from [Sanpham] where Id=? and Tensp=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, Id);
            stm.setString(2, Tensp);
            int result = stm.executeUpdate();
            stm.close();
            con.close();
            if (result > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
   
    

}
