package com.mdymen.jpaauxtable.entry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntryRepository extends CrudRepository<Entry, Long> {


    Optional<Entry> findByCorrelation(String correlationCompensatedBy);
}
