package com.geekbrains.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer priority;

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Task() {

    }

    public Task(Integer priority, String description, Date date) {
        this.priority = priority;
        this.description = description;
        this.date = date;
    }
}
