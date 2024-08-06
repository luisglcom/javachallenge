package com.luisglcom.javachallenge.enums;

/**
 * The enum Error code.
 */
public enum ErrorCode {

    /**
     * Ok error code.
     */
    OK(0, "OK"),

    /**
     * The Email is required.
     */
    EMAIL_IS_REQUIRED(1, "Error al crear el usuario. El campo email es requerido."),

    /**
     * The Password is required.
     */
    PASSWORD_IS_REQUIRED(2, "Error al crear el usuario. El campo password es requerido."),

    /**
     * The Email invalid format.
     */
    EMAIL_INVALID_FORMAT(3, "Error al crear el usuario. El campo email no tiene un formato válido."),

    /**
     * The Password invalid format.
     */
    PASSWORD_INVALID_FORMAT(4, "Error al crear el usuario. El campo password no tiene un formato válido."),

    /**
     * The Email already registered.
     */
    EMAIL_ALREADY_REGISTERED(5, "Error al crear el usuario. El campo email ya se encuentra registrado.");

    private final int code;
    private final String description;

    private ErrorCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;


    }
}