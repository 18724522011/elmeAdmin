package com.company.domain;

public class Admin
{
    private Integer admminId;
    private String  adminName;
    private String password;

    public Admin()
    {
    }

    public Admin(Integer admminId, String adminName, String password)
    {
        this.admminId = admminId;
        this.adminName = adminName;
        this.password = password;
    }

    public Integer getAdmminId()
    {
        return admminId;
    }

    public void setAdmminId(Integer admminId)
    {
        this.admminId = admminId;
    }

    public String getAdminName()
    {
        return adminName;
    }

    public void setAdminName(String adminName)
    {
        this.adminName = adminName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "Admin{" +
                "admminId=" + admminId +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
