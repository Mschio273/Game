package br.com.estudos.game.controller;

import br.com.estudos.game.model.Game;
import br.com.estudos.game.service.GameService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest
class GameControllerTest {

    @Autowired
    private GameController gameController;

    @MockBean
    private GameService gameService;

    @BeforeEach
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(this.gameController);
    }

    @Test
    public void givenValidScenario_whenFindAllIsCalled_thenReturnStatusOk() {

        when(this.gameService.findAll()).thenReturn(List.of(createGame()));

        RestAssuredMockMvc.given()
                .accept(ContentType.JSON)
                .when()
                .get("/api/v1/game")
                .then()
                .status(HttpStatus.OK);
    }

    @Test
    public void givenValidScenario_whenFindByIdIsCalled_thenReturnStatusOk() {

        when(this.gameService.findById(1L)).thenReturn(createGame());

        RestAssuredMockMvc.given()
                .accept(ContentType.JSON)
                .when()
                .get("/api/v1/game/{id}", 1L)
                .then()
                .status(HttpStatus.OK);
    }

    public Game createGame() {
        return Game.builder()
                .nome("sonic")
                .build();
    }
}