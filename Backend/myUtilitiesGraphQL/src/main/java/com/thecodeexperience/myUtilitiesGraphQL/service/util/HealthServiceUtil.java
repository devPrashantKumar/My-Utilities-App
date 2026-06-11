package com.thecodeexperience.myUtilitiesGraphQL.service.util;

import com.thecodeexperience.myUtilitiesGraphQL.Dtos.HealthDTO;
import com.thecodeexperience.myUtilitiesGraphQL.Entity.Health;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class HealthServiceUtil {

    public static HealthDTO getHealthDTO(Health health) {
        return HealthDTO
                .builder()
                .id(health.getId())
                .steps(health.getSteps())
                .water(health.getWater())
                .sleep(health.getSleep())
                .calories(health.getCalories())
                .dailyDiary(health.getDailyDiary())
                .expenses(health.getExpenses())
                .workout(health.getWorkout())
                .build();
    }
}
