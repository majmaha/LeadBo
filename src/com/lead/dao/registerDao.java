package com.lead.dao;

import com.lead.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Majd on 4/11/2017.
 */
public class registerDao {
    public static boolean insertUser(String company,String user, String password) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();

            pst = conn.prepareStatement("INSERT INTO users1 VALUES (?,?,?)");
            pst.setString(1, company);
            pst.setString(2, user);
            pst.setString(3, password);

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
