package com.mdymen.jpaauxtable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompensationRepository extends CrudRepository<Compensation, Long> {
}
