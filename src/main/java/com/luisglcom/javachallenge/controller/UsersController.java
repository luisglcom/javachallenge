package com.luisglcom.javachallenge.controller;

import com.luisglcom.javachallenge.controller.converter.UserRequestConverter;
import com.luisglcom.javachallenge.controller.converter.UserResponseConverter;
import com.luisglcom.javachallenge.openapi.api.UsersApi;
import com.luisglcom.javachallenge.openapi.model.UserRequest;
import com.luisglcom.javachallenge.openapi.model.UserResponse;
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
public class UsersController implements UsersApi {

    private final UsersService usersService;
    @Override
    public ResponseEntity<UserResponse> createUser(UserRequest body) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserResponseConverter.toResponse(usersService
                        .createUser(UserRequestConverter.toDomain(body))));
    }
}
