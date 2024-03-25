package com.jsp.springbootsimpleprojectcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jsp.springbootsimpleprojectcrud.dto.Student;

@Repository

public interface StudentRepository extends JpaRepository<Student, Integer>{

	public Student findByStudentEmail(String studentEmail);
	
	@Query(value = "delete from student where id=?1",nativeQuery = true)
	public void deleteByStudentId(int studentId);
}
