package com.guptha.springdataJpqlandanativesql.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.guptha.springdataJpqlandanativesql.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	@Query("from Student")
	List<Student> findAllStudents(Pageable pageable);

	@Query("select firstName,lastName from Student")
	List<Object[]> findAllStudentsPartialData();

	@Query("from Student where firstName = :firstName")
	List<Student> findAllStudentsByFirstName(@Param("firstName") String firstname);

	@Query("from Student where score > :min and score < :max")
	List<Student> findByStudentsByScore(@Param("min") int min, @Param("max") int max);

	@Modifying
	@Query("delete from Student where firstName = :firstName")
	void deleteStudentByFirstName(@Param("firstName") String firstName);

	@Query(value = "select * from student", nativeQuery = true)
	List<Student> findAllStudentsNQ();

	@Query(value = "select * from student where f_name = :firstName", nativeQuery = true)
	List<Student> findStudentByFirstNameNq(@Param("firstName") String firstName);

}
