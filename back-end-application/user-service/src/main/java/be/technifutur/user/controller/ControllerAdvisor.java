package be.technifutur.user.controller;

import be.technifutur.user.exception.ElementAlreadyExistsException;
import be.technifutur.user.exception.ElementNotFoundException;
import be.technifutur.user.model.dto.ErrorDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<Object> handleElementNotFound(ElementNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        ErrorDTO.builder()
                                .message(ex.getMessage())
                                .uri(request.getRequestURI())
                                .method(HttpMethod.resolve(request.getMethod()))
                                .build()
                );
    }

    @ExceptionHandler(ElementAlreadyExistsException.class)
    public ResponseEntity<Object> handleElementAlreadyExists(ElementAlreadyExistsException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        ErrorDTO.builder()
                                .message(ex.getMessage())
                                .uri(request.getRequestURI())
                                .method(HttpMethod.resolve(request.getMethod()))
                                .build()
                );
    }
}
