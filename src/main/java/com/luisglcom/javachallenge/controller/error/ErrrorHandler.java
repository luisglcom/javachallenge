package com.luisglcom.javachallenge.controller.error;

import com.luisglcom.javachallenge.exception.UsersModelException;
import com.luisglcom.javachallenge.openapi.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The type Errror handler.
 */
@RestControllerAdvice
public class ErrrorHandler {

    /**
     * The constant BAD_REQUEST.
     */
    public static final Integer BAD_REQUEST = 400;
    /**
     * The constant NOT_FOUND.
     */
    public static final Integer NOT_FOUND = 404;
    /**
     * The constant INTERNAL_ERROR.
     */
    public static final Integer INTERNAL_ERROR = 500;


    /**
     * Users model exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(UsersModelException.class)
    public ResponseEntity<ErrorResponse> usersModelException(UsersModelException e) {
        ErrorResponse response = new ErrorResponse();
        response.setMensaje(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
