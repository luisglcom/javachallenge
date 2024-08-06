package com.luisglcom.javachallenge.exception;

import java.time.LocalDateTime;

/**
 * The type Users model exception.
 */
public class UsersModelException extends UsersException {

    private static final long serialVersionUID = -3388289147789860561L;

    /**
     * Instantiates a new Users model exception.
     *
     * @param message   the message
     * @param errorCode the error code
     */
    public UsersModelException (String message, Integer errorCode, LocalDateTime timestamp) {
        super(message, errorCode, timestamp);
    }

}
