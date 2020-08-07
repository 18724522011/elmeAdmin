package com.company;

import com.company.domain.Admin;
import com.company.view.AdminView;
import com.company.view.impl.AdminViewImpl;

import java.util.Scanner;

public class ElmAdmin
{
    public static void main(String[] args) {
        work();
    }
    public static  void  work(){
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------");
        System.out.println("|\t\t\t\t饿了么控制台版后台管理系统 V1.0\t\t\t\t|");
        System.out.println("-----------------------------------------------------------");

        // 调用登录方法
        AdminView adminView = new AdminViewImpl();
        Admin admin = adminView.login();

        if (admin!=null){
            System.out.println("~欢迎来到饿了么商家管理系统~");
            // 创建一个菜单
            int menu=0;
            while(menu!=5){

            System.out.println("========= 1.所有商家列表=2.搜索商家=3.新建商家=4.删除商家=5.退出系统 =========");
            System.out.println("请输入相应的菜单编号");
           menu=input.nextInt();

                switch (menu){
                    case 1:
                        System.out.println("1.所有商家列表");
                        break;
                    case 2:
                        System.out.println("2.搜索商家");
                        break;
                    case 3:
                        System.out.println("3.新建商家");
                        break;
                    case 4:
                        System.out.println("4.删除商家");
                        break;
                    case 5:
                        System.out.println("========欢迎下次光临饿了么系统");
                        break;
                    default:
                        System.out.println("没有这个菜单项");
                        break;
                }

            }

        }else{
            System.out.println("账号或密码有误请重新输入");
        }

    }
}
