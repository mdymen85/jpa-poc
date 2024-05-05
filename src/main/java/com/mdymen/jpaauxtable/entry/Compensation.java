package com.mdymen.jpaauxtable.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//select c1_0.id,cb1_0.id,cb1_0.correlation,ce1_0.id,c2_0.id,c2_0.compensated_entry,ce1_0.correlation
// from compensation c1_0
// left join entity cb1_0 on cb1_0.id=c1_0.compensated_by
// left join entity ce1_0 on ce1_0.id=c1_0.compensated_entry
// left join compensation c2_0 on ce1_0.id=c2_0.compensated_by
// where c1_0.compensated_by=?

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
@Data
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "compensation")
//@SecondaryTable(name = "compensationsEntry")
public class Compensation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entry_id", referencedColumnName = "id")
    private Entry compensatedEntry;

}