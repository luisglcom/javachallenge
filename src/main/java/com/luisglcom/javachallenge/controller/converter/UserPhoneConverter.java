package com.luisglcom.javachallenge.controller.converter;

import com.luisglcom.javachallenge.dto.UserPhoneDto;
import com.luisglcom.javachallenge.openapi.model.Phone;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

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
            userPhones.add(toDomain(phone));
        }
        return userPhones;
    }
}
