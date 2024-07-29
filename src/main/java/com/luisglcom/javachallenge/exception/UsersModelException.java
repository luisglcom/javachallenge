package com.luisglcom.javachallenge.exception;

/**
 * The type Users model exception.
 */
public class UsersModelException extends UsersException {

    private static final long serialVersionUID = -3388289147789860561L;

    /**
     * Instantiates a new Users model exception.
     *
     * @param message    the message
     * @param httpStatus the http status
     */
    public UsersModelException (String message, Integer httpStatus) {
        super(message, String.valueOf(httpStatus));
    }

}
