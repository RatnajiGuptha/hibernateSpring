package com.guptha.springdata.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import com.guptha.springdata.patientscheduling.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {

}
