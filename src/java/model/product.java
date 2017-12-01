/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import controller.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author hpt
 */
public class product {

    private double IDproduct;
    private String nameproduct;
    private String image;
    private String price;

    public product() {
    }

    public product(double IDproduct, String nameproduct, String image, String price) {
        this.IDproduct = IDproduct;
        this.nameproduct = nameproduct;
        this.image = image;
        this.price = price;
    }

    public double getIDproduct() {
        return IDproduct;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public String getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }

    public void setIDproduct(double IDproduct) {
        this.IDproduct = IDproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public product[] getConnectProduct() {
        ConnectionDB c = new ConnectionDB();
        Connection con = c.connectData("Ass_java4");
        ArrayList list = new ArrayList();
        try {
            Statement st = con.createStatement();
            String s = "select * from Product";
            ResultSet rs = st.executeQuery(s);

            while (rs.next()) {
                product sp = new product();
                sp.setIDproduct(rs.getDouble(1));
                sp.setNameproduct(rs.getString(2));
                sp.setImage(rs.getString(4));
                sp.setPrice(rs.getString(3));
                list.add(sp);
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {

        }
        product[] sp = new product[list.size()];
        list.toArray(sp);
        return sp;
    }
}
