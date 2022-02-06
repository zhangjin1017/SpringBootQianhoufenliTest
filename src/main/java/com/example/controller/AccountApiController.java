package com.example.controller;

import com.example.entity.Account;
import com.example.entity.resp.RestBean;
import com.example.repo.AccountRepository;
import io.swagger.annotations.Api;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Api(tags = "用户信息接口", description = "包括用户信息更新、查询等操作。")
@RestController
@RequestMapping("/api/user")
public class AccountApiController {
    @Resource
    AccountRepository accountRepository;
    @GetMapping("/info")
    public RestBean<Account> info(){
        SecurityContext context = SecurityContextHolder.getContext();
       Account account= accountRepository.findByUsername(context.getAuthentication().getName());
       account.setPassword("");
        return new RestBean<>(200,"请求成功",account);
    }
}
