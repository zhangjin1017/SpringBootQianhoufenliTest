package com.example.service;

public interface VerifyService {
     void sendVerifyCode(String email);
     boolean doVerifyCode(String email,String code);
}
