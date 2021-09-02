package br.com.estudos.game.service;

import br.com.estudos.game.exception.NotFoundException;
import br.com.estudos.game.model.Game;
import br.com.estudos.game.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.estudos.game.errors.ErrorConstants.ID_MAIOR_QUE_ZERO;
import static br.com.estudos.game.errors.ErrorConstants.ID_NAO_ENCONTRADO;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> findAll() {
        return this.gameRepository.findAll();
    }

    public Game findById(Long id) {
        if (!isValidId(id)){
            throw new NotFoundException(ID_MAIOR_QUE_ZERO);
        }
        return this.gameRepository.findById(id).orElseThrow(() -> new NotFoundException(ID_NAO_ENCONTRADO));
    }

    public void update(Game game) {
        this.gameRepository.save(game);
    }

    public Game save(Game game) {
        this.gameRepository.save(game);
        return game;
    }

    public void delete(Long id) {
        if (!isValidId(id)){
            throw new NotFoundException(ID_MAIOR_QUE_ZERO);
        }
        this.gameRepository.delete(findById(id));
    }

    private boolean isValidId(Long id) {
        return id > 0;
    }
}