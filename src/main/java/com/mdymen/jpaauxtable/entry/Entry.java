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
@Table(name = "entry")
@AllArgsConstructor
@NoArgsConstructor
@SecondaryTable(name = "compensation", pkJoinColumns = @PrimaryKeyJoinColumn(name = "compensated_by_id"))
public class Entry  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String correlation;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Entry.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "compensated_entry_id", table = "compensation")
    private Entry compensatedEntry;

    @Transient
    private String correlationCompensatedBy;
}