package com.company.view.impl;

import com.company.dao.Impl.BusinessDaoImpl;
import com.company.domain.Business;
import com.company.view.BusinessView;

import java.util.List;

public class BusinessViewImpl implements BusinessView
{
    @Override
    public void listBusinessAll()
    {  BusinessDaoImpl dao=new  BusinessDaoImpl();
        List<Business > list=dao.findAll(null,null);
        System.out.println("");

    }
}
