package com.mihaisaizu.mypetclinic.services;

import com.mihaisaizu.mypetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
