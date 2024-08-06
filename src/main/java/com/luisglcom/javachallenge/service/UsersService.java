package com.luisglcom.javachallenge.service;

import com.luisglcom.javachallenge.dto.CreateRequestDto;
import com.luisglcom.javachallenge.dto.CreateResponseDto;

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
    CreateResponseDto createUser(CreateRequestDto userRequest);
}
