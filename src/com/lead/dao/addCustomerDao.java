package com.lead.dao;

import com.lead.ConnectionManager;
import java.sql.*;

/**
 * Created by Majd on 4/11/2017.
 */
public class addCustomerDao {
    public static boolean insertCustomer(String name,String  ID,String address,String phone,boolean club,int obligo,boolean wholesaler,int debt) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            System.out.print("<p style=\"color:red\">con est</p>");
            DatabaseMetaData dbm = conn.getMetaData();
            // check if "customers" table is there
            ResultSet tables = dbm.getTables(null, null, "customers", null);
            if (!tables.next()){
                System.out.print("table not found");
                pst = conn.prepareStatement("CREATE TABLE customers(name VARCHAR(20), ID VARCHAR(9),address VARCHAR(40),phone VARCHAR(10),club BOOLEAN,obligo INT ,wholesaler BOOLEAN ,debt INT,PRIMARY KEY (ID));");
                pst.executeUpdate();
            }
            pst = conn.prepareStatement("INSERT INTO customers VALUES (?,?,?,?,?,?,?,?)");
            pst.setString(1, name);
            pst.setString(2, ID);
            pst.setString(3, address);
            pst.setString(4, phone);
            pst.setBoolean(5, club);
            pst.setInt(6, obligo);
            pst.setBoolean(7, wholesaler);
            pst.setInt(8, debt);

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
