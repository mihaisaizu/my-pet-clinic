package com.mihaisaizu.mypetclinic.services;

import com.mihaisaizu.mypetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
