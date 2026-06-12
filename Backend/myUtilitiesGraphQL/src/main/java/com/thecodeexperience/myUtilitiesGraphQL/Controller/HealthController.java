package com.thecodeexperience.myUtilitiesGraphQL.Controller;

import com.thecodeexperience.myUtilitiesGraphQL.CO.HealthCO;
import com.thecodeexperience.myUtilitiesGraphQL.Dtos.HealthDTO;
import com.thecodeexperience.myUtilitiesGraphQL.service.HealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/health")
@RequiredArgsConstructor
public class HealthController {

    private final HealthService healthService;

    @PostMapping
    public ResponseEntity<HealthDTO> save(HealthCO healthCo){
        HealthDTO healthDTO = healthService.save(healthCo);
        return ResponseEntity.status(HttpStatus.CREATED).body(healthDTO);
    }

    @GetMapping
    public ResponseEntity<List<HealthDTO>> getAll(){
        return ResponseEntity.ok(healthService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthDTO> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(healthService.getById(id));
    }
}
