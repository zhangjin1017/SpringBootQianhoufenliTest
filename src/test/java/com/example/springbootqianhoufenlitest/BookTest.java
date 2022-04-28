package com.example.springbootqianhoufenlitest;

import com.example.entity.Book;
import com.example.repo.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
public class BookTest {
    @Resource
    BookRepository bookRepository;
    @Test
    public void add(){
        Book book = new Book();
        book.setName("book44");
        book.setAuthor("author4");
        book.setPrice(444.4);
        book.setDate(new Date());
        book.setType("type4");
        book.setDescription("description4");
        bookRepository.save(book);
    }
    @Test
    public void get() {
        System.out.println(bookRepository.findById(1));

    }
}
