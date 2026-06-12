package com.thecodeexperience.myUtilitiesGraphQL.Service;

import com.thecodeexperience.myUtilitiesGraphQL.CO.HealthCO;
import com.thecodeexperience.myUtilitiesGraphQL.Dtos.HealthDTO;
import com.thecodeexperience.myUtilitiesGraphQL.Entity.Health;
import com.thecodeexperience.myUtilitiesGraphQL.Exception.GenericStatusException;
import com.thecodeexperience.myUtilitiesGraphQL.Repository.HealthRepository;
import com.thecodeexperience.myUtilitiesGraphQL.Service.Util.HealthServiceUtil;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class HealthService {

    private final HealthRepository healthRepository;

    public HealthDTO save(HealthCO heathCo){
        Health health = healthRepository.save(HealthServiceUtil.getHealthEntity(heathCo));
        return HealthServiceUtil.getHealthDTO(health);
    }

    public List<HealthDTO> getAll(){
        List<Health> healthList = healthRepository.findAll();
        return healthList.stream().map(HealthServiceUtil::getHealthDTO).toList();
    }

    public HealthDTO getById(Long id){
        Health health = healthRepository.findById(id).orElseThrow(()->new GenericStatusException("item doesn't exists",400));
        return HealthServiceUtil.getHealthDTO(health);
    }
}
