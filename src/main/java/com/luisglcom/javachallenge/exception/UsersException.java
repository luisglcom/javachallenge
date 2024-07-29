package com.luisglcom.javachallenge.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * The type Gateway exception.
 */
@Data
public abstract class UsersException extends RuntimeException {


  /**
   * The Error code.
   */
  protected String errorCode;

  private HttpStatus httpStatus;

  private Object[] parameters;


  /**
   * Instantiates a new Users exception.
   */
  public UsersException() {
    super();
  }

  /**
   * Instantiates a new Users exception.
   *
   * @param message   the message
   * @param errorCode the error code
   */
  public UsersException(String message, String errorCode) {
    super(message);
    this.errorCode = errorCode;
  }

  /**
   * Instantiates a new Users exception.
   *
   * @param message    the message
   * @param httpStatus the http status
   */
  public UsersException(String message, HttpStatus httpStatus) {
    super(message);
    this.setHttpStatus(httpStatus);
  }

  /**
   * Instantiates a new Users exception.
   *
   * @param message the message
   */
  public UsersException(String message) {
    super(message);
  }

  /**
   * Instantiates a new Users exception.
   *
   * @param message the message
   * @param cause   the cause
   */
  public UsersException(String message, Throwable cause) {

  }
}
