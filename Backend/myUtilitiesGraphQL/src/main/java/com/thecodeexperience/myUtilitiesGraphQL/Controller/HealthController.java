package com.thecodeexperience.myUtilitiesGraphQL.Controller;

import com.thecodeexperience.myUtilitiesGraphQL.Dtos.HealthDTO;
import com.thecodeexperience.myUtilitiesGraphQL.service.HealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/health")
@RequiredArgsConstructor
public class HealthController {

    private final HealthService healthService;

    @GetMapping
    public List<HealthDTO> getAll(){
        return healthService.getAll();
    }

    @GetMapping("/{id}")
    public HealthDTO getById(@PathVariable("id") Long id){
        return healthService.getById(id);
    }
}
