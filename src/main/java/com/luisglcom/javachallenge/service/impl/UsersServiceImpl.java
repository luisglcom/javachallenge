package com.luisglcom.javachallenge.service.impl;

import com.luisglcom.javachallenge.dto.CreateRequestDto;
import com.luisglcom.javachallenge.dto.CreateResponseDto;
import com.luisglcom.javachallenge.enums.ErrorCode;
import com.luisglcom.javachallenge.exception.UsersModelException;
import com.luisglcom.javachallenge.model.UsersEntity;
import com.luisglcom.javachallenge.model.converter.UsersEntityConverter;
import com.luisglcom.javachallenge.repository.UsersRepository;
import com.luisglcom.javachallenge.service.UsersService;
import lombok.AllArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * The type Users service.
 */
@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    @Override
    public CreateResponseDto createUser(CreateRequestDto userRequest) {
        var userResponseDto = new CreateResponseDto();
        Optional<UsersEntity> user = usersRepository.findByEmail((userRequest.getEmail()));
        if (user.isPresent()) {
            throw new UsersModelException(ErrorCode.EMAIL_ALREADY_REGISTERED.getDescription(),
                    ErrorCode.EMAIL_INVALID_FORMAT.getCode(), LocalDateTime.now());
        } else {
            var usersEntity = usersRepository.save(UsersEntityConverter.toDB(userRequest));
            userResponseDto = UsersEntityConverter.toDomain(usersEntity);
        }
        return userResponseDto;
    }
}
