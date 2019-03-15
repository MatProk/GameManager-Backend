package com.wsiiz.gamemanager.message.request;

import lombok.Data;

@Data
public class GameRequest {
    private String name;
    private String author;
    private String description;
    private String gameMode;

    public GameRequest(String name, String author, String description, String gameMode) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.gameMode = gameMode;
    }
}
