package br.com.estudos.game.service;

import br.com.estudos.game.exception.NotFoundException;
import br.com.estudos.game.model.Game;
import br.com.estudos.game.repository.GameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    @Mock
    GameRepository gameRepository;

    @InjectMocks
    GameService gameService;

    @Test
    void givenValidScenario_whenFindAllIsCalled_thenShouldReturnGamesList(){

        Game game = Game.builder()
                .nome("sonic")
                .build();

        Game gamesEsperados = Game.builder()
                .nome("sonic")
                .build();

        List<Game> listaGames = List.of(gamesEsperados);

        when(gameRepository.findAll()).thenReturn(List.of(game));

        List<Game> response = gameService.findAll();

        assertEquals(listaGames, response);
    }

    @Test
    public void givenAValidIdAndExistentId_whenFindByIdIsCalled_thenShouldReturnAGame() {
        Game game = Game.builder()
                .id(1l)
                .nome("sonic")
                .build();

        when(this.gameRepository.findById(1L)).thenReturn(Optional.of(game));

        assertEquals(gameService.findById(1L), game);
    }

    @Test
    public void givenAInvalidId_whenFindByIdIsCalled_thenShouldThrowException() {

        String errorMessage = "id deve ser maior que zero";

        Exception exception = assertThrows(NotFoundException.class, () -> {
            gameService.findById(1L);
        });
    }
}