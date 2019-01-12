package com.mihaisaizu.mypetclinic.repositories;

import com.mihaisaizu.mypetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
