package com.thecodeexperience.myUtilitiesGraphQL.CO;

import com.thecodeexperience.myUtilitiesGraphQL.Enum.Workout;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HealthCO {
    private Long steps;
    private Long water;
    private Long calories;
    private Long sleep;
    private Workout workout;
    private String dailyDiary;
    private Long expenses;
}
