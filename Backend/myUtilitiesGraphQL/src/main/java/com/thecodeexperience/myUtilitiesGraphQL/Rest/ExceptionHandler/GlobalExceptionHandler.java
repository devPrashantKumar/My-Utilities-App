package com.thecodeexperience.myUtilitiesGraphQL.Rest.ExceptionHandler;

import com.thecodeexperience.myUtilitiesGraphQL.Dtos.ErrorResponseDTO;
import com.thecodeexperience.myUtilitiesGraphQL.Exception.GenericStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public static final String SOMETHING_WENT_WRONG = "Something went wrong";

    @ExceptionHandler(GenericStatusException.class)
    public ResponseEntity<ErrorResponseDTO> genericStatusExceptionHandler(GenericStatusException ex){
        return ResponseEntity
                .status(ex.getStatus())
                .body(new ErrorResponseDTO(ex.getMessage(), ex.getStatus()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> globalExceptionHandler(Exception ex){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponseDTO(SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }
}
