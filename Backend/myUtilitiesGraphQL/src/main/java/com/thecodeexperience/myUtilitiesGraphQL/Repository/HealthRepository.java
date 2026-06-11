package com.thecodeexperience.myUtilitiesGraphQL.Repository;

import com.thecodeexperience.myUtilitiesGraphQL.Entity.Health;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRepository extends JpaRepository<Health,Long> {

}
