package com.luisglcom.javachallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The type User request dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {

    private String name;
    private String email;
    private String password;
    private List<UserPhoneDto> phones;

}
