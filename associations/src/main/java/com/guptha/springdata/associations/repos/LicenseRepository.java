package com.guptha.springdata.associations.repos;

import org.springframework.data.repository.CrudRepository;

import com.guptha.springdata.associations.one2oneEntities.License;

public interface LicenseRepository extends CrudRepository<License, Long> {

}
