package com.mihaisaizu.mypetclinic.repositories;

import com.mihaisaizu.mypetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
