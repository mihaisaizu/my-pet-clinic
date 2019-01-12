package com.mihaisaizu.mypetclinic.repositories;

import com.mihaisaizu.mypetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
