package com.company.dao;

import com.company.domain.Business;

import java.util.List;

public interface BusinessDao
{
    //显示所有商家
   public List<Business> findAll(String businessName,String businessAddress);
}
