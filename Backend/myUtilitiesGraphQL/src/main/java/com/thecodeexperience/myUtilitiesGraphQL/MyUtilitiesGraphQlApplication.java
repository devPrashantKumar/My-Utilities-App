package com.thecodeexperience.myUtilitiesGraphQL;

import com.thecodeexperience.myUtilitiesGraphQL.Entity.Health;
import com.thecodeexperience.myUtilitiesGraphQL.Enum.Workout;
import com.thecodeexperience.myUtilitiesGraphQL.Repository.HealthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class MyUtilitiesGraphQlApplication implements CommandLineRunner {

	private final HealthRepository healthRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyUtilitiesGraphQlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Health healthEntry01 = new Health();
		healthEntry01.setSteps(10L);
		healthEntry01.setWater(7L);
		healthEntry01.setSleep(8L);
		healthEntry01.setCalories(2000L);
		healthEntry01.setDailyDiary("GOOD");
		healthEntry01.setExpenses(400L);
		healthEntry01.setWorkout(Workout.STRENGTH);
		healthRepository.save(healthEntry01);

		System.out.println("Running CommandLineRunner");
	}
}
