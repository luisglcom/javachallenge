package com.luisglcom.javachallenge.model.converter;

import com.luisglcom.javachallenge.dto.UserPhoneDto;
import com.luisglcom.javachallenge.model.UserPhonesEntity;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * The type User phones entity converter.
 */
@UtilityClass
public class UserPhonesEntityConverter {

    /**
     * To domain user phone dto.
     *
     * @param userPhonesEntity the user phones entity
     * @return the user phone dto
     */
    public static UserPhoneDto toDomain(UserPhonesEntity userPhonesEntity) {
        return UserPhoneDto.builder()
                .number(userPhonesEntity.getNumber())
                .cityCode(userPhonesEntity.getCityCode())
                .countryCode(userPhonesEntity.getCountryCode())
                .build();
    }

    /**
     * To db user phones entity.
     *
     * @param userPhoneDto the user phone dto
     * @return the user phones entity
     */
    public static UserPhonesEntity toDB(UserPhoneDto userPhoneDto) {
        var userPhonesEntity = new UserPhonesEntity();
        userPhonesEntity.setNumber(userPhoneDto.getNumber());
        userPhonesEntity.setCityCode(userPhoneDto.getCityCode());
        userPhonesEntity.setCountryCode(userPhoneDto.getCountryCode());
        return userPhonesEntity;
    }

    /**
     * List to domain list.
     *
     * @param userPhonesEntityList the user phones entity list
     * @return the list
     */
    public static List<UserPhoneDto> listToDomain(List<UserPhonesEntity> userPhonesEntityList) {
        List<UserPhoneDto> userPhoneDtoList = new ArrayList();
        for (UserPhonesEntity userPhonesEntity : userPhonesEntityList) {
            userPhoneDtoList.add(toDomain(userPhonesEntity));
        }
        return userPhoneDtoList;
    }

    /**
     * List to db list.
     *
     * @param userPhoneDtoList the user phone dto list
     * @return the list
     */
    public static List<UserPhonesEntity> listToDB(List<UserPhoneDto> userPhoneDtoList) {
        List<UserPhonesEntity> userPhonesEntityList = new ArrayList();
        for (UserPhoneDto userPhoneDto : userPhoneDtoList) {
            userPhonesEntityList.add(toDB(userPhoneDto));
        }
        return userPhonesEntityList;
    }

}
