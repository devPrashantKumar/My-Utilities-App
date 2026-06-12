package com.thecodeexperience.myUtilitiesGraphQL.Graphql.Resolver;

import com.thecodeexperience.myUtilitiesGraphQL.Dtos.HealthDTO;
import com.thecodeexperience.myUtilitiesGraphQL.Service.HealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HealthResolver {

    private final HealthService healthService;

    @QueryMapping
    public HealthDTO getById(@Argument Long id) {
        // Replace with your database lookup logic
        return healthService.getById(id);
    }

    @QueryMapping
    public List<HealthDTO> getAll() {
        // Replace with your database lookup logic
        return healthService.getAll();
    }
}

