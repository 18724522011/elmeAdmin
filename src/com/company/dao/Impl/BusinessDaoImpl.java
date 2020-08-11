package com.company.dao.Impl;

import com.company.dao.BusinessDao;
import com.company.domain.Admin;
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
    ResultSet rs = null;
    @Override
    public List<Business> findAll(String businessName, String businessAddress)
    {
        List<Business> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from business where 1=1");
        if (businessName != null && !businessName.equals("")){
            // 传入了商家名
            sql.append(" and businessName like '%").append(businessName).append("%' ");

        }
        if (businessAddress != null && !businessAddress.equals("")){
            // 传入了商家名
            sql.append(" and businessAddress like '%").append(businessAddress).append("%' ");

        }
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while (rs.next()){
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                // TODO
                list.add(business);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }


        return list;
    }

    @Override
    public Integer saveBusiness(String businessName)
            //附带一个初始化密码
    {  int businessId = 0;
        // 附带一个初始密码
        String sql = "insert into business(businessName, password)values(?, '123456')";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            // 可以在prepareStatement中设置返回自增长列的值
            pstmt.setString(1, businessName);
            pstmt.executeUpdate();
            // 获取自增长的列
            rs = pstmt.getGeneratedKeys();
            if (rs.next()){
                businessId = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return businessId;
    }
    @Override
    public int removeBusiness(int businessId) {
        int result = 0;
       // String delFootSql = "delete from food where businessId=?";
       String Sql = "delete from business where businessId=?";
        try {
            conn = JDBCUtils.getConnection();
            //开启一个事务
            conn.setAutoCommit(false);

          //  pstmt = conn.prepareStatement(delFootSql);
          //  pstmt.setInt(1, businessId);
            pstmt.executeUpdate();

            pstmt = conn.prepareStatement(Sql);
            pstmt.setInt(1, businessId);
            result = pstmt.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            //进入了异常的代码去要给代码去result置为0；
            result = 0;
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
           JDBCUtils.close(null, pstmt, conn);
        }
        return result;
    }



    @Override
    public Business getBusinessByNameByPass(Integer businessId, String password) {
        Business business = null;
        String sql = "select * from business where businessId = ? and password = ?";
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, businessId);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()){
                business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pstmt, conn);
        }

        return business;
    }

    @Override
    public Business getBusinessByBusinessId(Integer businessId)
    { Business business = null;
        String sql = "select * from business where businessId = ? ";
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, businessId);
            rs = pstmt.executeQuery();
            while (rs.next()){
                business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pstmt, conn);
        }

        return business;
    }
    @Override
    public int updateBusiness(Business business) {
        int result = 0;
        String sql = "update business set businessName = ?, businessAddress =?,businessExplain=? ,starPrice=?,deliveryPrice=? where businessId = ? ";
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, business.getBusinessName());
            pstmt.setString(2, business.getBusinessAddress());
            pstmt.setString(3, business.getBusinessExplain());
            pstmt.setDouble(4, business.getStarPrice());
            pstmt.setDouble(5, business.getDeliveryPrice());
            pstmt.setInt(6, business.getBusinessId());
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return result;
    }

    @Override
    public int updateBusinessByPassword(Integer businessId, String password)
    {
        int result = 0;
        String sql = "update business set password=? where businessId=?";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, password);
            pstmt.setInt(2, businessId);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, pstmt, conn);
        }
        return result;
    }
    }




