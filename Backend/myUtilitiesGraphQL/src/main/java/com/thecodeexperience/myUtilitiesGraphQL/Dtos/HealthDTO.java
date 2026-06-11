package com.thecodeexperience.myUtilitiesGraphQL.Dtos;

import com.thecodeexperience.myUtilitiesGraphQL.Enum.Workout;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HealthDTO {
    private Long id;
    private Long steps;
    private Long water;
    private Long calories;
    private Long sleep;
    private Workout workout;
    private String dailyDiary;
    private Long expenses;
}
