package com.luisglcom.javachallenge.controller.converter;

import com.luisglcom.javachallenge.dto.UserRequestDto;
import com.luisglcom.javachallenge.exception.UsersModelException;
import com.luisglcom.javachallenge.openapi.model.UserRequest;
import lombok.experimental.UtilityClass;
import org.apache.http.HttpStatus;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type User request converter.
 */
@UtilityClass
public class UserRequestConverter {

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
    public static UserRequestDto toDomain(UserRequest request) {
        validateRequest(request);
        return UserRequestDto.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .phones(UserPhoneConverter.listToDomain(request.getPhones()))
                .build();
    }

    private static void validateRequest(UserRequest request) {

        if (Objects.isNull(request.getName()) || request.getName().toString().isEmpty()) {
            throw new UsersModelException("Error al crear el usuario. El campo name es requerido.", HttpStatus.SC_BAD_REQUEST);
        }
        if (Objects.isNull(request.getEmail()) || request.getEmail().isEmpty()) {
            throw new UsersModelException("Error al crear el usuario. El campo email es requerido.", HttpStatus.SC_BAD_REQUEST);
        }
        if (Objects.isNull(request.getPassword()) || request.getPassword().isEmpty()) {
            throw new UsersModelException("Error al crear el usuario. El campo password es requerido.", HttpStatus.SC_BAD_REQUEST);
        }
        if (Objects.isNull(request.getPhones()) || request.getPhones().isEmpty()) {
            throw new UsersModelException("Error al crear el usuario. El campo phones es requerido.", HttpStatus.SC_BAD_REQUEST);
        }
        if (Objects.isNull(request.getPhones()) || request.getPhones().isEmpty()) {
            throw new UsersModelException("Error al crear el usuario. El campo phones es requerido.", HttpStatus.SC_BAD_REQUEST);
        }
        if (!(validateMail(request.getEmail()))) {
            throw new UsersModelException("Error al crear el usuario. El campo email no tiene un formato válido.", HttpStatus.SC_BAD_REQUEST);
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
