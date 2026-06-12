package com.thecodeexperience.myUtilitiesGraphQL;

import com.thecodeexperience.myUtilitiesGraphQL.Entity.Health;
import com.thecodeexperience.myUtilitiesGraphQL.Enum.Workout;
import com.thecodeexperience.myUtilitiesGraphQL.Repository.HealthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

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

		Health healthEntry2 = new Health();
		healthEntry2.setSteps(1000L);
		healthEntry2.setWater(7L);
		healthEntry2.setSleep(5L);
		healthEntry2.setCalories(1000L);
		healthEntry2.setDailyDiary("VERY GOOD");
		healthEntry2.setExpenses(100L);
		healthEntry2.setWorkout(null);
		List<Health> healthList = List.of(healthEntry01,healthEntry2);

		healthRepository.saveAll(healthList);

		System.out.println("Running CommandLineRunner");
	}
}
