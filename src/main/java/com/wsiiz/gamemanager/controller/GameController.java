package com.wsiiz.gamemanager.controller;

import com.wsiiz.gamemanager.domain.Game;
import com.wsiiz.gamemanager.exception.ResourceNotFoundException;
import com.wsiiz.gamemanager.message.request.GameRequest;
import com.wsiiz.gamemanager.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        gameRepository.save(new Game(gameRequest.getName(), gameRequest.getAuthor(), gameRequest.getDescription(), gameRequest.getGameMode(), gameRequest.getReleaseDate(), gameRequest.getPayload()));
    }

    @GetMapping("/games/{id}")
    public Optional<Game> getOneGame(@PathVariable Long id){return gameRepository.findById(id);}

    @DeleteMapping("/games/{id}")
    public void deleteGame(@PathVariable Long id){
        gameRepository.deleteById(id);
    }

    @PutMapping("/games/{id}")
    public void updateGame(@PathVariable(value = "id") Long id,
                           @RequestBody GameRequest gameRequest) {

        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game", "id", id));

        game.setName(gameRequest.getName());
        game.setAuthor(gameRequest.getAuthor());
        game.setDescription(gameRequest.getDescription());
        game.setReleaseDate(gameRequest.getReleaseDate());
        game.setGameMode(gameRequest.getGameMode());

        gameRepository.save(game);

    }
}
