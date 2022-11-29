package com.guptha.springdataJpqlandanativesql;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;

import com.guptha.springdataJpqlandanativesql.entities.Student;
import com.guptha.springdataJpqlandanativesql.repo.StudentRepository;

@SpringBootTest
class JpqlandanativesqlApplicationTests {

	@Autowired
	StudentRepository repo;

//	@Test
	void contextLoads() {
	}

//	@Test
	void testCreateStudent() {
		Student student = new Student();
		student.setFirstName("ratnaji");
		student.setlastName("Guptha");
		student.setScore(78);

		Student student2 = new Student();
		student2.setFirstName("talluri");
		student2.setlastName("Guptha");
		student2.setScore(87);

		repo.save(student);
		repo.save(student2);
	}

//	@Test
	void testFindAllJpql() {
		Pageable pageable = PageRequest.of(0, 2, Direction.ASC, "score");
		repo.findAllStudents(pageable).forEach(p -> System.err.println(p.toString()));

	}

//	@Test
	void testFindAllPartialData() {
		List<Object[]> partialData = repo.findAllStudentsPartialData();
		for (Object[] objects : partialData) {
			System.err.println("first name " + objects[0] + " and last name " + objects[1]);
		}
	}

//	@Test
	void testFindAllStudentsByFirstName() {
		System.err.println(repo.findAllStudentsByFirstName("talluri"));
	}

//	@Test
	void testFindAllStudentsByScore() {
		System.err.println(repo.findByStudentsByScore(70, 90));
	}

//	@Test
	@Transactional
	@Rollback(false)
	void testDeleteStudnetByFirstName() {
		repo.deleteStudentByFirstName("talluri");
	}

//	@Test
	void testFindAllNq() {
		System.err.println(repo.findAllStudentsNQ());
	}

	@Test
	void testFindbyFirstNameNq() {
		System.err.println(repo.findStudentByFirstNameNq("talluri"));
	}
}
