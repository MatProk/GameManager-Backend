package com.wsiiz.gamemanager.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 3, max = 500)
    private String name;

    @Column(nullable = false)
    @Size(min = 3, max = 500)
    private String author;


    @Column(nullable = false)
    @Size(min = 3, max = 500)
    private String gameMode;

    @Column(nullable = false)
    private Date releaseDate;

    @Column(nullable = false)
    private String description;

    public Game(String name, String author, String gameMode, Date releaseDate, String description) {
        this.name = name;
        this.author = author;
        this.gameMode = gameMode;
        this.releaseDate = releaseDate;
        this.description = description;
    }

    public Game() {
    }


}
