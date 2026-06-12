package com.thecodeexperience.myUtilitiesGraphQL.Controller;

import com.thecodeexperience.myUtilitiesGraphQL.Dtos.HealthDTO;
import com.thecodeexperience.myUtilitiesGraphQL.service.HealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class HealthGraphqlController {

    private final HealthService healthService;

    @QueryMapping
    public HealthDTO getById(@Argument Long id) {
        // Replace with your database lookup logic
        return healthService.getById(id);
    }
}

