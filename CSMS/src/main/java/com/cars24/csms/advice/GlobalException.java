package com.cars24.csms.advice;

import com.cars24.csms.Exception.UserServiceException;
import com.cars24.csms.data.response.ApiResponse;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException exception) {
        log.info("[handleValidationExceptions] Validation failed");

        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errorMap);
    }

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<ApiResponse> handleUserServiceException(UserServiceException exception) {
        log.error("[handleUserServiceException] UserServiceException occurred: {}", exception.getMessage());

        ApiResponse response = new ApiResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setSuccess(false);
        response.setMessage(exception.getMessage());
        response.setData(null);
        response.setService("userService");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGeneralExceptions(Exception exception) {
        log.error("[handleGeneralExceptions] Unexpected error: {}", exception.getMessage());

        ApiResponse response = new ApiResponse();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setSuccess(false);
        response.setMessage("An unexpected error occurred. Please try again later.");
        response.setData(null);
        response.setService("global");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
