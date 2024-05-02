package com.mdymen.jpaauxtable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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