package com.luisglcom.javachallenge.controller.converter;

import com.luisglcom.javachallenge.dto.CreateResponseDto;
import com.luisglcom.javachallenge.openapi.model.CreateResponse;
import lombok.experimental.UtilityClass;

/**
 * The type User response converter.
 */
@UtilityClass
public class CreateResponseConverter {

    /**
     * To response user response.
     *
     * @param createResponseDto the user response dto
     * @return the user response
     */
    public static CreateResponse toResponse(CreateResponseDto createResponseDto) {
        var createResponse = new CreateResponse();
        createResponse.setId(createResponseDto.getId());
        createResponse.setCreated(createResponseDto.getCreated());
        createResponse.setModified(createResponseDto.getModified());
        createResponse.setLastLogin(createResponseDto.getLastLogin());
        createResponse.setToken(createResponseDto.getToken());
        createResponse.setIsactive(createResponseDto.getIsActive());
        return createResponse;
    }
}
