package com.thecodeexperience.myUtilitiesGraphQL.service;

import com.thecodeexperience.myUtilitiesGraphQL.Dtos.HealthDTO;
import com.thecodeexperience.myUtilitiesGraphQL.Entity.Health;
import com.thecodeexperience.myUtilitiesGraphQL.Repository.HealthRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class HealthService {

    private final HealthRepository healthRepository;

    public List<HealthDTO> getAll(){
        List<Health> healthList = healthRepository.findAll();
        return healthList.stream().map(HealthService::getHealthDTO).toList();
    }

    private static HealthDTO getHealthDTO(Health health) {
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
