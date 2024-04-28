package com.mdymen.jpaauxtable;

import jakarta.persistence.*;

@Entity
public class Compensation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "compensatedBy")
    private Entry compensatedBy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "compensatedEntry")
    private Entry compensatedEntry;


}