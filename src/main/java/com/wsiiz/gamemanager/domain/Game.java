package com.wsiiz.gamemanager.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Long id;

    @Length(max = 100, min = 5)
    @Column(nullable = false)
    private String name;

    @Length(max = 100, min = 5)
    @Column(nullable = false)
    private String author;

    @Length(max = 500, min = 5)
    @Column(nullable = false)
    private String description;

    @Length(max = 100, min = 5)
    @Column(nullable = false)
    private String gameMode;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    @Lob
    @Column(name = "payload")
    private String payload;

    public Game(String name, String author, String description, String gameMode, Date releaseDate, String payload) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.gameMode = gameMode;
        this.releaseDate = releaseDate;
        this.payload = payload;
    }

    public Game(){

    }
}
