package br.com.estudos.game.controller;

import br.com.estudos.game.model.Game;
import br.com.estudos.game.service.GameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/game")
@Api(value = "API REST de Games")
@CrossOrigin(origins = "*")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Retorna uma lista de games")
    public List<Game> findAll() {
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Retorna um game")
    public Game findById(@PathVariable Long id) {
        return gameService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Insere um game")
    public Game save(@RequestBody Game game) {
        return gameService.save(game);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Atualiza um game")
    public void update(@RequestBody Game game) {
        gameService.update(game);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Deleta um game")
    public void delete(@PathVariable Long id) {
        gameService.delete(id);
    }
}
