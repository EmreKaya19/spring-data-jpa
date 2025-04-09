package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entities.student;

@Repository
public interface StudentRepository extends JpaRepository<student, Integer>{
	
	@Query(value = "select * from student.student", nativeQuery = true)
	List<student> findallstudentList();
 
	
	@Query(value = " from student s where s.id=:id", nativeQuery = false)
	Optional<student> findstudentListbyid(Integer id);
}
