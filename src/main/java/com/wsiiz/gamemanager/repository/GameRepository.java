package com.wsiiz.gamemanager.repository;

import com.wsiiz.gamemanager.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long>{
}
