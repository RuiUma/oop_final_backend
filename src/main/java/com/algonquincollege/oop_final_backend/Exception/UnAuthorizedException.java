package com.algonquincollege.oop_final_backend.Exception;

public class UnAuthorizedException extends RuntimeException {
  public UnAuthorizedException(String message) {
    super(message);
  }
}
