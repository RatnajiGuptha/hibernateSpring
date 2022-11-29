package com.guptha.springdata.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import com.guptha.springdata.patientscheduling.entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
