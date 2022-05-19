package dev.ji.javacalc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DividingByZeroException extends RuntimeException {
    public DividingByZeroException(String message) {
        super(message);
    }
}
