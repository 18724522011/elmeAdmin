package com.company.dao.Impl;

import com.company.dao.AdminDao;
import com.company.domain.Admin;
import com.company.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao
{
    private Connection conn =null;
    private PreparedStatement pstmt =null;
    private ResultSet rs =null;

    @Override
    public Admin getAdminByNameByPass(String adminName, String password)
    {   Admin admin=null;
        String sql="select * from admin where adminName= ? and password = ?";
         try{
           conn= JDBCUtils.getConnection();

           pstmt=conn.prepareStatement(sql);
           pstmt.setString(1,adminName);
             pstmt.setString(2, password );
             rs=pstmt.executeQuery();
             while(rs.next()){
                admin=new Admin();
               admin.setAdmminId(rs.getInt("adminId"));
               admin.setPassword(rs.getString("password"));
               admin.setAdminName(rs.getString("adminName"));

             }
    } catch (SQLException e)
         {
             e.printStackTrace();
         }
        return admin;
    }
}
