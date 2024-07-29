package com.luisglcom.javachallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * The type Error response dto.
 */
@Data
@Builder
@AllArgsConstructor
public class ErrorResponseDto {

    private String mensaje;
}
