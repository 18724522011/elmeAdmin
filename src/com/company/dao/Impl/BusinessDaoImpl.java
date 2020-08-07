package com.company.dao.Impl;

import com.company.dao.BusinessDao;
import com.company.domain.Business;
import com.company.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao
{
     private Connection conn = null;

     private PreparedStatement pstmt=null;
    private ArrayList<Business> list=null;
    ResultSet rs = null;
    @Override
    public List<Business> findAll(String businessName, String businessAddress)
    {

        StringBuffer sql=new StringBuffer("select * from business where 1=1");

        if(businessName !=null && !businessName.equals(""))
    {
        sql.append("and business like '%").append(businessName).append("%'");
        System.out.println(sql);
    }
        if(businessAddress !=null && !businessAddress.equals(""))
        {
            sql.append("and business like '%").append(businessAddress).append("%'");
            System.out.println(sql);
        }
        try{
            conn= JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql.toString());
            rs=pstmt.executeQuery();
            while(rs.next()){
                Business business=new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
              business.setBusinessName(rs.getString("businessName"));
                list.add(business);

            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }
}
