package com.mdymen.jpaauxtable.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mdymen.jpaauxtable.meal.Person;
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

//@Embeddable
////@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
////@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
//@Data
////@Builder
//@NoArgsConstructor
//@AllArgsConstructor
////@Table(name = "compensation")
////@SecondaryTable(name = "compensationsEntry")
//public class Compensation {
//
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
//
//    @OneToOne(fetch = FetchType.LAZY, targetEntity = Entry.class, cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "compensated_entry_id", table = "compensation")
//    private Entry compensatedEntry;
//
//}


/*

[
    {
        "id": 1,
        "correlation": "5e2c89d9-f328-4caa-b3e5-94684816489c",
        "compensation": null,
        "correlationCompensatedBy": null
    },
    {
        "id": 2,
        "correlation": "413762bc-6c8c-4e2c-8a10-8bfd3edcf9c0",
        "compensation": {
            "compensatedEntry": {
                "id": 1,
                "correlation": "5e2c89d9-f328-4caa-b3e5-94684816489c",
                "compensation": null,
                "correlationCompensatedBy": null
            }
        },
        "correlationCompensatedBy": null
    },
    {
        "id": 3,
        "correlation": "d5be9d7c-bf0d-413d-9141-89cd3f7c18b9",
        "compensation": null,
        "correlationCompensatedBy": null
    },
    {
        "id": 4,
        "correlation": "be9f7923-739a-499f-92b2-ad5d38a06950",
        "compensation": {
            "compensatedEntry": {
                "id": 3,
                "correlation": "d5be9d7c-bf0d-413d-9141-89cd3f7c18b9",
                "compensation": null,
                "correlationCompensatedBy": null
            }
        },
        "correlationCompensatedBy": null
    }
]



 */