package com.example.service.impl;

import com.example.entity.Book;
import com.example.repo.BookRepository;
import com.example.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookRepository bookRepository;
    @Override
    public List<Book> getAllBooks() {
        List<Book> list = bookRepository.findAll();

        return list;
    }
}
