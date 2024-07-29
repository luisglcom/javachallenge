package com.luisglcom.javachallenge.service;

import com.luisglcom.javachallenge.dto.UserRequestDto;
import com.luisglcom.javachallenge.dto.UserResponseDto;

/**
 * The interface Users service.
 */
public interface UsersService {

    /**
     * Create user user response dto.
     *
     * @param userRequest the user request
     * @return the user response dto
     */
    UserResponseDto createUser(UserRequestDto userRequest);
}
