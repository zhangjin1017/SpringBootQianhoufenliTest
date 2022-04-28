package com.example.springbootqianhoufenlitest;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test1 {
    @Test
    public void fun1(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123456"));
    }
    @Test
    public void fun2() {
        java.util.Date  date=new java.util.Date();
        java.sql.Date  sqldate=new java.sql.Date(date.getTime());
        System.out.println(date);
        System.out.println(sqldate);
    }
}
