package com.wsiiz.gamemanager.message.request;

import lombok.Data;

@Data
public class GameRequest {

    private String name;

    private String author;

    private String gameMode;

    private String description;
}
