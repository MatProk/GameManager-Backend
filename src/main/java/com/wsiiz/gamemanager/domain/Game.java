package com.wsiiz.gamemanager.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Length(max = 50, min = 5)
    @Column(nullable = false)
    private String name;

    @Length(max = 50, min = 5)
    @Column(nullable = false)
    private String author;

    @Length(max = 500, min = 10)
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String gameMode;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date releaseDate;

    public Game(String name, String author, String description, String gameMode, Date releaseDate) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.gameMode = gameMode;
        this.releaseDate = releaseDate;
    }

    public Game(){

    }
}
