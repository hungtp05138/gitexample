/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author hpt
 */
public class loginbean implements Serializable{
    public loginbean(){
        
    }
    
    public boolean checklogin (String username, String password){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-0RMJURM\\HTP:1433;databaseName=Ass_java4";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "Select * from Login where username=? and password=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            boolean result = rs.next();
            rs.close();
            pst.close();
            con.close();
            if(result){
                return true;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean insert (String name, String price, String Image){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-0RMJURM\\HTP:1433;databaseName=Ass_java4";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "insert into Product(nameproduct, price, image)" + "values(?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, price);
            pst.setString(3, Image);
            int result = pst.executeUpdate();
            pst.close();
            con.close();
            if(result > 0){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean checkDelete(String name) {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-0RMJURM\\HTP:1433;databaseName=Ass_java4";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "DELETE FROM Product WHERE nameproduct = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            boolean result = rs.next();
            rs.close();
            pst.close();
            con.close();
            if(result){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean checkUpload(String ten, String gia, String img, String id) {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-0RMJURM\\HTP:1433;databaseName=Ass_java4";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "Update Product set nameproduct=?,price=?,image=? where nameproduct = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, ten);
            pst.setString(2, gia);
            pst.setString(3, img);
            pst.setString(4, ten);
            ResultSet rs = pst.executeQuery();
            boolean result = rs.next();
            rs.close();
            pst.close();
            con.close();
            if(result){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
