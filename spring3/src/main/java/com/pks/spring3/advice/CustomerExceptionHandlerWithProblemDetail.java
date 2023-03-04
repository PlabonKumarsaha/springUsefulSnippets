package com.pks.spring3.advice;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerExceptionHandlerWithProblemDetail {

  @ExceptionHandler(RuntimeException.class)
  public ProblemDetail onException(RuntimeException ex){
    ProblemDetail problemDetail = org.springframework.http.ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400),
        ex.getMessage());
    return problemDetail;
  }
}
