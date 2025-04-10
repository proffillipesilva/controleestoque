package com.fiec.estoqueia.config.exception;

import com.fiec.estoqueia.business.dtos.ErrorDto;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    //public ProblemDetail handleSecurityException(Exception exception) {
    public ResponseEntity<ErrorDto> handleSecurityException(Exception exception) {
        ProblemDetail errorDetail = null;

        // TODO send this stack trace to an observability tool
        exception.printStackTrace();

        if (exception instanceof BadCredentialsException) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(401), exception.getMessage());
            errorDetail.setProperty("description", "The username or password is incorrect");

            //return errorDetail;
            return new ResponseEntity<>(ErrorDto.builder().build(), HttpStatus.UNAUTHORIZED);
        }

        if (exception instanceof AccountStatusException) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), exception.getMessage());
            errorDetail.setProperty("description", "The account is locked");
        }

        if (exception instanceof AccessDeniedException) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), exception.getMessage());
            errorDetail.setProperty("description", "You are not authorized to access this resource");
        }

        if (exception instanceof SignatureException) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(401), exception.getMessage());
            errorDetail.setProperty("description", "The JWT signature is invalid");
            //errorDetail.setStatus(HttpStatus.UNAUTHORIZED);
            //throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Not authorized");
            return new ResponseEntity<>(ErrorDto.builder()
                    .message("The JWT signature is invalid")
                    .status("40101")
                    .build(), HttpStatus.UNAUTHORIZED);

        }

        if (exception instanceof ExpiredJwtException) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(401), exception.getMessage());
            errorDetail.setProperty("description", "The JWT token has expired");
            //errorDetail.setStatus(HttpStatus.UNAUTHORIZED);
            //throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Not authorized");
            return new ResponseEntity<>(ErrorDto.builder()
                    .message("The JWT signature is invalid")
                    .status("40101")
                    .build(), HttpStatus.UNAUTHORIZED);
        }

        if (errorDetail == null) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500), exception.getMessage());
            errorDetail.setProperty("description", "Unknown internal server error.");
        }

        return new ResponseEntity<>(ErrorDto.builder().build(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}