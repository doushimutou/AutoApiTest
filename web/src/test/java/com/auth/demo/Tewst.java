package com.auth.demo;

/**
 * Description
 * Author ayt  on
 */
public class Tewst {

    String str = new String("hello");
    char[] ch = {'a', 'b', 'c'};

    public void fun(String str1, char ch1[]) {
        str = "world";
        ch[0] = 'd';
    }

    public static void main(String[] args) {
        Tewst tewst = new Tewst();
        tewst.fun(tewst.str,tewst.ch);
        System.out.println(tewst.str+" ssssssss ");
        System.out.println(tewst.ch);
    }
}
