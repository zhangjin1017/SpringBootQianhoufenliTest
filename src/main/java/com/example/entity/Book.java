package com.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    private double price;
    @Column(name = "date")
    private Date date;
    @Column(name = "type")
    private String type;
    @Column(name = "description")
    private String description;

}
