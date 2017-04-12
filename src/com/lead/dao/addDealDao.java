package com.lead.dao;

import com.lead.ConnectionManager;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by Majd on 4/12/2017.
 */
public class addDealDao {
    public static boolean insertDeal(String dealName, String dealDetails, Date startDate, Date endDate, Date curDate, String dealType,String dealItems,String dealCustomers,String dealBranches) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            System.out.print("<p style=\"color:red\">con est</p>");
            DatabaseMetaData dbm = conn.getMetaData();
            // check if "customers" table is there
            ResultSet tables = dbm.getTables(null, null, "deals", null);
            if (!tables.next()){
                System.out.print("table not found");
                pst = conn.prepareStatement("CREATE TABLE deals(dealName VARCHAR(20), dealDetails VARCHAR(100),startDate DATE ,endDate DATE,creationDate DATE ,dealType VARCHAR(30),dealItems VARCHAR(30),dealCustomers VARCHAR(30),dealBranches VARCHAR(30));");
                pst.executeUpdate();
            }
            pst = conn.prepareStatement("INSERT INTO deals VALUES (?,?,?,?,?,?,?,?,?)");
            pst.setString(1, dealName);
            pst.setString(2, dealDetails);
            java.sql.Date startingDate = new java.sql.Date(startDate.getTime());
            pst.setDate(3, startingDate);
            java.sql.Date endingDate = new java.sql.Date(endDate.getTime());
            pst.setDate(4, endingDate);
            java.sql.Date creationDate = new java.sql.Date(curDate.getTime());
            pst.setDate(5, creationDate);
            pst.setString(6, dealType);
            pst.setString(7, dealItems);
            pst.setString(8, dealCustomers);
            pst.setString(9,dealBranches);

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
