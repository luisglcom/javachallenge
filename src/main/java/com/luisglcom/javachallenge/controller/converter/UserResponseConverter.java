package com.luisglcom.javachallenge.controller.converter;

import com.luisglcom.javachallenge.dto.UserResponseDto;
import com.luisglcom.javachallenge.openapi.model.UserResponse;
import lombok.experimental.UtilityClass;

/**
 * The type User response converter.
 */
@UtilityClass
public class UserResponseConverter {

    /**
     * To response user response.
     *
     * @param userResponseDto the user response dto
     * @return the user response
     */
    public static UserResponse toResponse(UserResponseDto userResponseDto) {
        var userResponse = new UserResponse();
        userResponse.setId(userResponseDto.getId());
        userResponse.setCreated(userResponseDto.getCreated());
        userResponse.setModified(userResponseDto.getModified());
        userResponse.setLastLogin(userResponseDto.getLastLogin());
        userResponse.setToken(userResponseDto.getToken());
        userResponse.setIsactive(userResponseDto.getIsActive());
        return userResponse;
    }
}
