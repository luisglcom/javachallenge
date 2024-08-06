package com.luisglcom.javachallenge.model.converter;

import com.luisglcom.javachallenge.dto.CreateRequestDto;
import com.luisglcom.javachallenge.dto.CreateResponseDto;
import com.luisglcom.javachallenge.model.UsersEntity;
import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * The type Users entity converter.
 */
@UtilityClass
public class UsersEntityConverter {

    /**
     * To domain user response dto.
     *
     * @param usersEntity the users entity
     * @return the user response dto
     */
    public static CreateResponseDto toDomain(UsersEntity usersEntity) {
        return CreateResponseDto.builder()
                .id(usersEntity.getId())
                .created(usersEntity.getCreated() == null ? null : LocalDateTime
                        .ofInstant(usersEntity.getCreated().toInstant(), ZoneId.systemDefault()))
                .modified(usersEntity.getModified() == null ? null : LocalDateTime
                        .ofInstant(usersEntity.getModified().toInstant(), ZoneId.systemDefault()))
                .lastLogin(usersEntity.getLastLogin() == null ? null : LocalDateTime
                        .ofInstant(usersEntity.getLastLogin().toInstant(), ZoneId.systemDefault()))
                .token(usersEntity.getToken())
                .isActive(usersEntity.getIsActive())
                .build();
    }

    /**
     * To db users entity.
     *
     * @param createRequestDto the user request dto
     * @return the users entity
     */
    public static UsersEntity toDB(CreateRequestDto createRequestDto) {

        var userEntity = new UsersEntity();
        userEntity.setName(createRequestDto.getName());
        userEntity.setEmail(createRequestDto.getEmail());
        userEntity.setPassword(createRequestDto.getPassword());
        userEntity.setPhones(UserPhonesEntityConverter.listToDB(createRequestDto.getPhones()).stream().map(i -> {
                    i.setUser(userEntity);
                    return i;
                }).collect(Collectors.toList()));

        userEntity.setCreated(Date.from(Instant.now()));
        userEntity.setModified(Date.from(Instant.now()));
        userEntity.setToken(UUID.randomUUID().toString());
        userEntity.setIsActive(true);
        return userEntity;
    }
}
