package com.example.controller;

import com.example.entity.Account;
import com.example.entity.Book;
import com.example.entity.resp.RestBean;
import com.example.repo.AccountRepository;
import com.example.repo.BookRepository;
import com.example.service.BookService;
import io.swagger.annotations.Api;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookApiController {
    @Resource
    BookService bookService;
    @GetMapping("/list")
    public RestBean<List> info(){
        List<Book> list = bookService.getAllBooks();
        return new RestBean<>(200,"请求成功",list);
    }
}
