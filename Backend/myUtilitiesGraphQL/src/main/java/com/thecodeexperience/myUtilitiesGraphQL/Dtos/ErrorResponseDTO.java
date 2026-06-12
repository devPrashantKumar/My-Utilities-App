package com.thecodeexperience.myUtilitiesGraphQL.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO {
    private Long timestamp;
    private String formattedTimeStamp;
    private String error;
    private String message;
    private Integer status;

    public ErrorResponseDTO(String message, Integer status) {
        this.status = status;
        this.timestamp = Instant.now().toEpochMilli();
        this.formattedTimeStamp = Instant.now()
                .atZone(ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern("yyyy MMM dd HH:mm:ss.SSS zzz"));
        this.message = message;
    }
}
