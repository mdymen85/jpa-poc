package com.mdymen.jpaauxtable.meal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "meal")
@SecondaryTable(name = "allergens", pkJoinColumns = @PrimaryKeyJoinColumn(name = "meal_id"))
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealWithEmbeddedAllergens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "price")
    BigDecimal price;

    @Embedded
    AllergensAsEmbeddable allergens;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Person.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person_id", table = "allergens")
    private Person person;

}
