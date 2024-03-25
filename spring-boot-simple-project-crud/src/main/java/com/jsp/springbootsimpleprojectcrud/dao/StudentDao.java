package com.jsp.springbootsimpleprojectcrud.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springbootsimpleprojectcrud.dto.Student;
import com.jsp.springbootsimpleprojectcrud.repository.StudentRepository;

@Repository
public class StudentDao {

	public int addThreeNumber(int a, int b, int c) {
		return a + b + c;
	}

	@Autowired
	private StudentRepository repository;

	public Student saveStudentDao(Student student) {
		return repository.save(student);
	}

	public boolean deleteStudentByIdDao(int studentId) {

		Optional<Student> optional = repository.findById(studentId);

		if (optional.isPresent()) {
			repository.delete(optional.get());
			return true;
		} else {
			return false;
		}
	}

	/**
	 * get by id method
	 */
	public Student getStudentByIdDao(int studentId) {
		Optional<Student> optional = repository.findById(studentId);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	/*
	 * find all method
	 */
	public List<Student> getAllStudentDataDao(){
		
		return repository.findAll();
	}
	
	public List<Student> saveMultipleStudentDao(List<Student> students){
		return repository.saveAll(students);
	}
	
	public List<Student> getAllStudentOnly4DigitsIdDao(){
		
		return getAllStudentDataDao();
	}
	
	public Student findByStudentEmailDao(String studentEmail) {
		return repository.findByStudentEmail(studentEmail);
	}
	
	public void deleteByStudentIdDao(int studentId) {
		repository.deleteByStudentId(studentId);
	}
	
//	public boolean updateStudentNameByIdDao(Student studentId) {
//
//		Optional<Student> optional = repository.findById(studentId.getStudentId());
//
//		if (optional.isPresent()) {
//			Student student = optional.get();
//			student.setStudentName(studentId.getStudentName());
//			repository.save(student);
//			return true;
//		} else {
//			return false;
//		}
//	}

}
