package com.thecodeexperience.myUtilitiesGraphQL.Graphql.Resolver;

import com.thecodeexperience.myUtilitiesGraphQL.CO.HealthCO;
import com.thecodeexperience.myUtilitiesGraphQL.Dtos.HealthDTO;
import com.thecodeexperience.myUtilitiesGraphQL.Service.HealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HealthResolver {

    private final HealthService healthService;

    @MutationMapping
    public HealthDTO createHealth(@Argument("input") HealthCO healthCo) {
        return healthService.save(healthCo);
    }

    @QueryMapping
    public HealthDTO getById(@Argument Long id) {
        return healthService.getById(id);
    }

    @QueryMapping
    public List<HealthDTO> getAll() {
        return healthService.getAll();
    }
}

