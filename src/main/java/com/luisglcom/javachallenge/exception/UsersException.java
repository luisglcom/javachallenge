package com.luisglcom.javachallenge.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * The type Gateway exception.
 */
@Data
public abstract class UsersException extends RuntimeException {


  /**
   * The Error code.
   */
  protected Integer errorCode;

  private HttpStatus httpStatus;

  private LocalDateTime timestamp;

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
   * @param timestamp the timestamp
   */
  public UsersException(String message, Integer errorCode, LocalDateTime timestamp) {
    super(message);
    this.errorCode = errorCode;
    this.timestamp = timestamp;
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
