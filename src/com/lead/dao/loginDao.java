/**
 * Created by Majd on 4/11/2017.
 */
package com.lead.dao;

import com.lead.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDao {
    public static boolean validate(String company,String user, String password) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;


        try {
            conn = ConnectionManager.getConnection();

            pst = conn.prepareStatement("select * from users1 where user=? and password=? and company=?");
            pst.setString(1, user);
            pst.setString(2, password);
            pst.setString(3, company);

            rs = pst.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
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