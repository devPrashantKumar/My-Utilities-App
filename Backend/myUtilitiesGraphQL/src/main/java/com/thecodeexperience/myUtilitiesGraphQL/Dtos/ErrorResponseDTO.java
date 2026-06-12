package com.thecodeexperience.myUtilitiesGraphQL.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO {
    private Long timestamp;
    private String error;
    private String message;
    private Integer status;

    public ErrorResponseDTO(String message, Integer status) {
        this.status = status;
        this.timestamp = new Date().getTime();
        this.message = message;
    }
}
