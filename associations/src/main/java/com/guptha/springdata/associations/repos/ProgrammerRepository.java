package com.guptha.springdata.associations.repos;

import org.springframework.data.repository.CrudRepository;

import com.guptha.springdata.associations.many2manyEnitites.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {

}
