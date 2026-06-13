package com.thecodeexperience.myUtilitiesGraphQL.Entity;

import com.thecodeexperience.myUtilitiesGraphQL.Enum.Workout;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
