package com.geekbrains.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "genre")
    private String genre;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private Float price;

}
