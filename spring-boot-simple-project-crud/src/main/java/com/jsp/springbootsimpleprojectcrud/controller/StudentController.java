package com.jsp.springbootsimpleprojectcrud.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.jsp.springbootsimpleprojectcrud.dto.Student;
import com.jsp.springbootsimpleprojectcrud.response.ResponseStructure;
import com.jsp.springbootsimpleprojectcrud.service.StudentService;

@RestController
@RequestMapping(value = "getStudent")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = "/myData")
	public String getData() {
		
		return "Todays Date is = "+LocalDate.now();
	}
	
	@GetMapping(value = "/addTwoNumber/{a}/{b}")
	public int addTwoNumber(@PathVariable Integer a,@PathVariable Integer b) {
		
		return a+b;
	}
	
	
	public double getPrice(int a,int b) {
		return a*b;
	}
	
	@PostMapping(value = "/saveStudent")
	public ResponseStructure<Student> saveStudentController(@RequestBody Student student) {
		return studentService.saveStudentService(student);
	}
	
	@DeleteMapping(value = "deleteStudent/{studentId}")
	public String deleteStudentByIdController(@PathVariable int studentId) {
		boolean b=studentService.deleteStudentByIdService(studentId);
		if(b) {
			return "data deletd";
		}else {
			return "data not deleted";
		}
	}
	
	@GetMapping(value = "/getStudentById/{studentId}")
	public ResponseStructure<Student> getStudentByIdController(@PathVariable int studentId) {
		return studentService.getStudentByIdService(studentId);
	}
	
	@GetMapping(value = "/getAllData")
	public ResponseStructure<List<Student>> getAllStudentDataController() {

		return studentService.getAllStudentDataService();
	}
	
	
	@PostMapping(value = "/saveMultipleStudent")
	public ResponseStructure<List<Student>> saveMultipleStudentController(@RequestBody List<Student> students){
		
		return studentService.saveMultipleStudentService(students);
	}
	
	@GetMapping("/getFilterData")
	public ResponseStructure<List<Student>> getAllStudentOnly4DigitsIdController(){
		return studentService.getAllStudentOnly4DigitsIdService();
	}
	
	@GetMapping("/getStudentEmail/{studentEmail}")
	public Student findByStudentEmailService(@PathVariable String studentEmail) {
		return studentService.findByStudentEmailService(studentEmail);
	}
	
	@DeleteMapping(value = "/deleteById/{studentId}")
	public void deleteByStudentService(@PathVariable int studentId) {
		studentService.deleteStudentByIdService(studentId);
	}
	
	@PutMapping(value = "/updateName")
	public boolean updateStudentNameByIdService(@RequestBody Student studentId) {
		return updateStudentNameByIdService(studentId);
	}

}
