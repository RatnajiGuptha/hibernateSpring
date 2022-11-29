package com.guptha.springdata.patientscheduling;

import java.util.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.guptha.springdata.patientscheduling.entities.Appointment;
import com.guptha.springdata.patientscheduling.entities.Doctor;
import com.guptha.springdata.patientscheduling.entities.Insurance;
import com.guptha.springdata.patientscheduling.entities.Patient;
import com.guptha.springdata.patientscheduling.repos.AppointmentRepository;
import com.guptha.springdata.patientscheduling.repos.DoctorRepository;
import com.guptha.springdata.patientscheduling.repos.PatientRepository;

@SpringBootTest
class PatientschedulingApplicationTests {

	@Autowired
	DoctorRepository doctorRepo;

	@Autowired
	PatientRepository patientRepo;

	@Autowired
	AppointmentRepository appointmentRepo;

	@Test
	void testCreateDoctor() {

		Doctor doctor = new Doctor();

		doctor.setFirstName("ratnaji");
		doctor.setLastName("guptha");
		doctor.setSpeciality("All");

		doctorRepo.save(doctor);
	}

	@Test
	void testCreatePatient() {
		Patient patient = new Patient();
		patient.setFirstName("doug");
		patient.setLastName("bailey");
		patient.setPhone("98765689189");

		Insurance insurance = new Insurance();
		insurance.setProviderName("Blue Cross Blue Shield");
		insurance.setCopay(20d);

		Doctor doctor = doctorRepo.findById(1L).get();
		List<Doctor> doctors = Arrays.asList(doctor);

		patient.setDoctors(doctors);
		patient.setInsurance(insurance);
		patientRepo.save(patient);
	}

	@Test
	void testCreateAppointment() {

		Appointment appointment = new Appointment();

		Timestamp appointmentTime = new Timestamp(new Date().getTime());
		appointment.setAppointmnetTime(appointmentTime);
		appointment.setReason("I have a problem");
		appointment.setStarted(true);

		appointment.setPatient(patientRepo.findById(1L).get());
		appointment.setDoctor(doctorRepo.findById(1L).get());

		appointmentRepo.save(appointment);

	}
}
