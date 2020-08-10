package com.company.Test;


import com.company.dao.Impl.BusinessDaoImpl;

public class TestBusiness
{
    public static void main(String[] args)
    {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        //dao.findAll("饺子","null");
       // dao.findAll(null,  null);
        dao.findAll(null,  "沈阳");

    }
}
