package com.lead.dao;

import com.lead.ConnectionManager;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Majd on 4/12/2017.
 */
public class addItemDao {
    public static boolean insertItem(int id, String name, String barCode, String description,
                                     double price, double costPrice, boolean withTax, boolean weighable
                                     , boolean hide, int departmentId, int byUser) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            System.out.print("<p style=\"color:red\">con est</p>");
            DatabaseMetaData dbm = conn.getMetaData();
            // check if "items" table is there
            ResultSet tables = dbm.getTables(null, null, "Items", null);
            if (!tables.next()){
                System.out.print("table not found");
                pst = conn.prepareStatement("CREATE TABLE items(ID INT,name VARCHAR(50),barcode VARCHAR(100),details " +
                        "VARCHAR(200),price DOUBLE ,cost DOUBLE ,withTax BOOLEAN,weightable BOOLEAN,creationDate DATE,hide BOOLEAN,departmentId INT ,byUser INT );");
                pst.executeUpdate();
            }
            pst = conn.prepareStatement("INSERT INTO items VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1,id);
            pst.setString(2, name);
            pst.setString(3, barCode);
            pst.setString(4, description);
            pst.setDouble(5, price);
            pst.setDouble(6, costPrice);
            pst.setBoolean(7, withTax);
            pst.setBoolean(8,weighable);
            SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
            Date curDate=new Date();
            System.out.print(sdf.format(curDate));
            java.sql.Date creationDate = new java.sql.Date(curDate.getTime());
            pst.setDate(9, creationDate);
            pst.setBoolean(10,hide);
            pst.setInt(11,departmentId);
            pst.setInt(12,byUser);


            pst.execute();
            status = true;

        } catch (Exception e) {
            System.out.println(e);
            status=false;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;
    }
}
