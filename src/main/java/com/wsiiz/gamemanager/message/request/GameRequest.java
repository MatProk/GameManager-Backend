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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;
    private String payload;

    public GameRequest(String name, String author, String description, String gameMode, Date releaseDate, String payload) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.gameMode = gameMode;
        this.releaseDate = releaseDate;
        this.payload = payload;
    }
}
