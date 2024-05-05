package com.mdymen.jpaauxtable.entry;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Data
@SuperBuilder(toBuilder = true)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
@Table(name = "entry")
@AllArgsConstructor
@NoArgsConstructor
public class Entry  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String correlation;

    @OneToOne(mappedBy = "compensatedEntry", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private Compensation compensation;

    @Transient
    private String correlationCompensatedBy;
}