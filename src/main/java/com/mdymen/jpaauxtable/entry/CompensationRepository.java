package com.mdymen.jpaauxtable.entry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompensationRepository extends CrudRepository<Compensation, Long> {


//    Optional<Compensation> findByCorrelation(String correlationCompensatedBy);
}
