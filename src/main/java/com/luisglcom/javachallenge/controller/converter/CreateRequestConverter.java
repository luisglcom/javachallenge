package com.luisglcom.javachallenge.controller.converter;

import com.luisglcom.javachallenge.dto.CreateRequestDto;
import com.luisglcom.javachallenge.enums.ErrorCode;
import com.luisglcom.javachallenge.exception.UsersModelException;
import com.luisglcom.javachallenge.openapi.model.CreateRequest;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type User request converter.
 */
@UtilityClass
public class CreateRequestConverter {

    /**
     * The constant VALID_EMAIL_ADDRESS_REGEX.
     */
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    /**
     * To domain user request dto.
     *
     * @param request the request
     * @return the user request dto
     */
    public static CreateRequestDto toDomain(CreateRequest request) {
        validateRequest(request);
        return CreateRequestDto.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .phones(UserPhoneConverter.listToDomain(request.getPhones()))
                .build();
    }

    private static void validateRequest(CreateRequest request) {

        if (Objects.isNull(request.getEmail()) || request.getEmail().isBlank()) {
            throw new UsersModelException(ErrorCode.EMAIL_IS_REQUIRED.getDescription(),
                    ErrorCode.EMAIL_IS_REQUIRED.getCode(), LocalDateTime.now());
        }
        if (Objects.isNull(request.getPassword()) || request.getPassword().isBlank()) {
            throw new UsersModelException(ErrorCode.PASSWORD_IS_REQUIRED.getDescription(),
                    ErrorCode.PASSWORD_IS_REQUIRED.getCode(), LocalDateTime.now());
        }
        if (!(validateMail(request.getEmail()))) {
            throw new UsersModelException(ErrorCode.EMAIL_INVALID_FORMAT.getDescription(),
                    ErrorCode.EMAIL_INVALID_FORMAT.getCode(), LocalDateTime.now());
        }
    }

    /**
     * Validate mail boolean.
     *
     * @param emailStr the email str
     * @return the boolean
     */
    public static boolean validateMail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }
}
