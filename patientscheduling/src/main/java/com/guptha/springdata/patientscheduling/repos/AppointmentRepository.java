package com.guptha.springdata.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import com.guptha.springdata.patientscheduling.entities.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
