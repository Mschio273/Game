package br.com.estudos.game.repository;

import br.com.estudos.game.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
