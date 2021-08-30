package br.com.estudos.game.controller;

import br.com.estudos.game.model.Game;
import br.com.estudos.game.service.GameService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class GameControllerTest2 {

    @InjectMocks
    private GameController gameController;

    @Mock
    private GameService gameService;

    private Game createGame() {
        return Game.builder()
                .nome("sonic")
                .build();
    }

    @BeforeEach
    public void setUp() {
        List<Game> games = List.of(createGame());
        BDDMockito.when(gameService.findAll())
                .thenReturn(games);
    }

    @Test
    public void test() {
        List<Game> listaDeGame = gameController.findAll();

        Assertions.assertThat(listaDeGame).isNotNull();

        Assertions.assertThat(List.of(listaDeGame)).isNotEmpty();
    }
}