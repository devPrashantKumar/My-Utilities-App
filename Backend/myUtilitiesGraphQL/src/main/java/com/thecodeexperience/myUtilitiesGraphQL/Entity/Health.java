package com.thecodeexperience.myUtilitiesGraphQL.Entity;

import com.thecodeexperience.myUtilitiesGraphQL.Enum.Workout;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Health {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long steps;
    private Long water;
    private Long calories;
    private Long sleep;
    private Workout workout;
    private String dailyDiary;
    private Long expenses;
}
