package be.technifutur.market.controller;

import be.technifutur.market.exception.MarketPriceNotFoundException;
import be.technifutur.market.model.dto.ErrorDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class MarketControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MarketPriceNotFoundException.class)
    public ResponseEntity<Object> handlePrice404(MarketPriceNotFoundException ex, HttpServletRequest req){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorDto.builder()
                        .message(ex.getMessage())
                        .method(HttpMethod.resolve(req.getMethod()))
                        .uri(req.getRequestURI())
                        .build());
    }
}
