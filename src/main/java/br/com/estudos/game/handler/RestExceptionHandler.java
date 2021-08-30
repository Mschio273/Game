package br.com.estudos.game.handler;

import br.com.estudos.game.exception.NotFoundException;
import br.com.estudos.game.exception.NotFoundExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundExceptionDetails> handlerBadRequestException(NotFoundException nfe){
        return new ResponseEntity<>(
                NotFoundExceptionDetails.builder()
                        .timeStamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .title("Bad request exception, check the documentation")
                        .details(nfe.getMessage())
                        .developerMessage(nfe.getClass().getName())
                        .build(), HttpStatus.NOT_FOUND);
    }
}
