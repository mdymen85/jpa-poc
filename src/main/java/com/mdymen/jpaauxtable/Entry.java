package com.mdymen.jpaauxtable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "entity")
@Entity
@Data
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String correlation;

    @OneToOne(mappedBy = "compensatedBy", cascade = CascadeType.PERSIST)
    private Compensation compensation;

    @Transient
    private String correlationCompensatedBy;
}
