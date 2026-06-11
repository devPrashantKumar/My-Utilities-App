package com.thecodeexperience.myUtilitiesGraphQL.service;

import com.thecodeexperience.myUtilitiesGraphQL.Dtos.HealthDTO;
import com.thecodeexperience.myUtilitiesGraphQL.Entity.Health;
import com.thecodeexperience.myUtilitiesGraphQL.Repository.HealthRepository;
import com.thecodeexperience.myUtilitiesGraphQL.service.util.HealthServiceUtil;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class HealthService {

    private final HealthRepository healthRepository;

    public List<HealthDTO> getAll(){
        List<Health> healthList = healthRepository.findAll();
        return healthList.stream().map(HealthServiceUtil::getHealthDTO).toList();
    }
}
