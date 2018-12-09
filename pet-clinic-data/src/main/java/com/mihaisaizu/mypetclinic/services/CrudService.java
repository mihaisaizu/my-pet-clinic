package com.mihaisaizu.mypetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T ojbect);

    void deleteById(T object);
}
