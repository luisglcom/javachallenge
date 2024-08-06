package com.luisglcom.javachallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * The type User response dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateResponseDto {

    private Integer id;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private String token;
    private Boolean isActive;
}
