package com.luisglcom.javachallenge.service.impl;

import com.luisglcom.javachallenge.dto.UserRequestDto;
import com.luisglcom.javachallenge.dto.UserResponseDto;
import com.luisglcom.javachallenge.exception.UsersModelException;
import com.luisglcom.javachallenge.model.UsersEntity;
import com.luisglcom.javachallenge.model.converter.UsersEntityConverter;
import com.luisglcom.javachallenge.repository.UsersRepository;
import com.luisglcom.javachallenge.service.UsersService;
import lombok.AllArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The type Users service.
 */
@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    @Override
    public UserResponseDto createUser(UserRequestDto userRequest) {
        var userResponseDto = new UserResponseDto();
        Optional<UsersEntity> user = usersRepository.findByEmail((userRequest.getEmail()));
        if (user.isPresent()) {
            throw new UsersModelException("Error al crear el usuario. El campo email ya se encuentra registrado.", HttpStatus.SC_CONFLICT);
        } else {
            var usersEntity = usersRepository.save(UsersEntityConverter.toDB(userRequest));
            userResponseDto = UsersEntityConverter.toDomain(usersEntity);
        }
        return userResponseDto;
    }
}
