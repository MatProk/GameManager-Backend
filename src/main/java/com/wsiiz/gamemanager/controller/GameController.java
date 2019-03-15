package com.wsiiz.gamemanager.controller;

import com.wsiiz.gamemanager.domain.Game;
import com.wsiiz.gamemanager.message.request.GameRequest;
import com.wsiiz.gamemanager.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @GetMapping("/games")
    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    @PostMapping("/games")
    public void saveGame(@RequestBody GameRequest gameRequest){
        gameRepository.save(new Game(gameRequest.getName(), gameRequest.getAuthor(), gameRequest.getDescription(), gameRequest.getGameMode(), new Date()));
    }
}
