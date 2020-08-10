package com.company.view;

import com.company.domain.Business;

public interface BusinessView
{
    public void listBusinessAll();
    public void listBusinessBySearch();
    public void saveBusiness();
    public void removeBusiness();

    public Business login();
}
