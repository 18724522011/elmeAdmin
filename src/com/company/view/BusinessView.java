package com.company.view;

import com.company.domain.Business;

public interface BusinessView
{
    public void listBusinessAll();
    public void listBusinessBySearch();
    public void saveBusiness();
    public void removeBusiness();

    public Business login();
    //显示商家信息
    public  void showBusinessInfo(Integer businessId);

    // 修改商家信息
    public void updateBusinessInfo(Integer businessId);
}
