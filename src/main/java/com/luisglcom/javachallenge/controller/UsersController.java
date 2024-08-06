package com.luisglcom.javachallenge.controller;

import com.luisglcom.javachallenge.controller.converter.CreateRequestConverter;
import com.luisglcom.javachallenge.controller.converter.CreateResponseConverter;
import com.luisglcom.javachallenge.openapi.api.SignUpApi;
import com.luisglcom.javachallenge.openapi.model.CreateRequest;
import com.luisglcom.javachallenge.openapi.model.CreateResponse;
import com.luisglcom.javachallenge.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Users controller.
 */
@AllArgsConstructor
@RestController
public class UsersController implements SignUpApi {

    private final UsersService usersService;
    @Override
    public ResponseEntity<CreateResponse> createUser(CreateRequest body) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(CreateResponseConverter.toResponse(usersService
                        .createUser(CreateRequestConverter.toDomain(body))));
    }
}
