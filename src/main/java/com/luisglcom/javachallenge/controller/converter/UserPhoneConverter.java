package com.luisglcom.javachallenge.controller.converter;

import com.luisglcom.javachallenge.dto.UserPhoneDto;
import com.luisglcom.javachallenge.exception.UsersModelException;
import com.luisglcom.javachallenge.openapi.model.Phone;
import com.luisglcom.javachallenge.openapi.model.UserRequest;
import lombok.experimental.UtilityClass;
import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type User phone converter.
 */
@UtilityClass
public class UserPhoneConverter {

    /**
     * To response phone.
     *
     * @param userPhone the user phone
     * @return the phone
     */
    public static Phone toResponse(UserPhoneDto userPhone) {
        var phone = new Phone();
        phone.setNumber(userPhone.getNumber());
        phone.setCitycode(userPhone.getCityCode());
        phone.setCountrycode(userPhone.getCountryCode());
        return phone;
    }

    /**
     * To domain user phone dto.
     *
     * @param phone the phone
     * @return the user phone dto
     */
    public static UserPhoneDto toDomain(Phone phone) {
        return UserPhoneDto.builder()
                .number(phone.getNumber())
                .cityCode(phone.getCitycode())
                .countryCode(phone.getCountrycode())
                .build();
    }

    /**
     * List to response list.
     *
     * @param userPhones the user phones
     * @return the list
     */
    public static List<Phone> listToResponse(List<UserPhoneDto> userPhones) {
        List<Phone> phones = new ArrayList<>();
        for (UserPhoneDto userPhone : userPhones) {
            phones.add(toResponse(userPhone));
        }
        return phones;
    }

    /**
     * List to domain list.
     *
     * @param phones the phones
     * @return the list
     */
    public static List<UserPhoneDto> listToDomain(List<Phone> phones) {
        List<UserPhoneDto> userPhones = new ArrayList<>();
        for (Phone phone : phones) {
            validatePhoneRequest(phone);
            userPhones.add(toDomain(phone));
        }
        return userPhones;
    }

    private static void validatePhoneRequest(Phone phone) {

        if (Objects.isNull(phone.getNumber()) || phone.getNumber().toString().isEmpty()) {
            throw new UsersModelException("Error al crear el usuario. El campo number de phone es requerido.", HttpStatus.SC_BAD_REQUEST);
        }
        if (Objects.isNull(phone.getCitycode())) {
            throw new UsersModelException("Error al crear el usuario. El campo citycode de phone es requerido.", HttpStatus.SC_BAD_REQUEST);
        }
        if (Objects.isNull(phone.getCountrycode())) {
            throw new UsersModelException("Error al crear el usuario. El campo countrycode de phone es requerido.", HttpStatus.SC_BAD_REQUEST);
        }
    }
}
