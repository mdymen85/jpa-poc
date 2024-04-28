package com.mdymen.jpaauxtable;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "entity")
@Entity
@Data
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String name;

    @OneToOne(mappedBy = "compensatedBy")
    private Compensation compensation;
}
