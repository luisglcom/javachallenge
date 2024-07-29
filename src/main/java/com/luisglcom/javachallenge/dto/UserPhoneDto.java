package com.luisglcom.javachallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type User phone dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPhoneDto {
    private String number;
    private Integer cityCode;
    private Integer countryCode;
}