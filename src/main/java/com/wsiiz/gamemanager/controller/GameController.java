package com.wsiiz.gamemanager.controller;


import com.wsiiz.gamemanager.domain.Game;
import com.wsiiz.gamemanager.message.request.GameRequest;
import com.wsiiz.gamemanager.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @GetMapping("/game")
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @PostMapping("/game")
    public void saveGame(@RequestBody GameRequest gameRequest) {
        gameRepository.save(new Game(gameRequest.getName(), gameRequest.getAuthor(), gameRequest.getDescription(), new Date(), gameRequest.getGameMode()));
    }

    @PutMapping("/game/{idGame}")
    public ResponseEntity<Object> updateGame(@RequestBody Game game, @PathVariable long id) {

        Optional<Game> gameOptional = gameRepository.findById(id);

        if (!gameOptional.isPresent())
            return ResponseEntity.notFound().build();

        game.setId(id);
        gameRepository.save(game);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/game/{idGame}")
    void deleteGame(@PathVariable Long idGame) {
        gameRepository.deleteById(idGame);

    }
}







