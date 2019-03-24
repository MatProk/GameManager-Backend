package com.wsiiz.gamemanager.message.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class GameRequest {
    private String name;
    private String author;
    private String description;
    private String gameMode;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date releaseDate;

    public GameRequest(String name, String author, String description, String gameMode, Date releaseDate) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.gameMode = gameMode;
        this.releaseDate = releaseDate;
    }
}
