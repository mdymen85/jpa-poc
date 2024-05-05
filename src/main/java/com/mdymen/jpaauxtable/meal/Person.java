package com.mdymen.jpaauxtable.meal;

import com.mdymen.jpaauxtable.entry.Compensation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = MealWithEmbeddedAllergens.class, mappedBy = "person")
    private MealWithEmbeddedAllergens mealWithEmbeddedAllergens;

}
