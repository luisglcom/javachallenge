package com.luisglcom.javachallenge.repository;

import com.luisglcom.javachallenge.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Users repository.
 */
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

    /**
     * Find by email optional.
     *
     * @param email the email
     * @return the optional
     */
    Optional<UsersEntity> findByEmail(String email);
}
