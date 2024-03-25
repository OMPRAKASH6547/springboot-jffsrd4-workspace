package com.jsp.springbootsimpleprojectcrud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.springbootsimpleprojectcrud.dao.StudentDao;
import com.jsp.springbootsimpleprojectcrud.dto.Student;
import com.jsp.springbootsimpleprojectcrud.response.ResponseStructure;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private ResponseStructure<Student> responseStructure;
	
	@Autowired
	private ResponseStructure<List<Student>> responseStructure2;

	public ResponseStructure<Student> saveStudentService(Student student) {

		Student student2 = studentDao.saveStudentDao(student);

		if (student2 != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setStatusMessage("data---stored");
			responseStructure.setStatusDescription("data is stored please dont save again same id");
			responseStructure.setStatusData(student2);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setStatusMessage("data-is-not--stored");
			responseStructure.setStatusDescription("may be primary key is already present or check your code...");
			responseStructure.setStatusData(student2);
		}

		return responseStructure;
	}

	public boolean deleteStudentByIdService(int studentId) {
		return studentDao.deleteStudentByIdDao(studentId);
	}

	public ResponseStructure<Student> getStudentByIdService(int studentId) {

		Student student2 = studentDao.getStudentByIdDao(studentId);

		if (student2 != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setStatusMessage("data---found");
			responseStructure.setStatusDescription("gsavjkbdslnsdlknlkdlcmnmkd");
			responseStructure.setStatusData(student2);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setStatusMessage("data-is-not--found");
			responseStructure.setStatusDescription("please check your id");
			responseStructure.setStatusData(student2);
		}

		return responseStructure;
	}

	public ResponseStructure<List<Student>> getAllStudentDataService() {

		List<Student> list=studentDao.getAllStudentDataDao();
		
		if(list!=null) {
			responseStructure2.setStatusCode(HttpStatus.FOUND.value());
			responseStructure2.setStatusMessage("data-is-not--found");
			responseStructure2.setStatusDescription("please check your id");
			responseStructure2.setStatusData(list);
		}else {
			responseStructure2.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure2.setStatusMessage("data-is-not--found");
			responseStructure2.setStatusDescription("please check your id");
			responseStructure2.setStatusData(list);
		}
		
		return responseStructure2;
	}
	
	public ResponseStructure<List<Student>> saveMultipleStudentService(List<Student> students){
		
		List<Student> list=studentDao.saveMultipleStudentDao(students);
		
		if(list!=null) {
			responseStructure2.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure2.setStatusMessage("data-is-not--found");
			responseStructure2.setStatusDescription("please check your id");
			responseStructure2.setStatusData(list);
		}else {
			responseStructure2.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure2.setStatusMessage("data-is-not--found");
			responseStructure2.setStatusDescription("please check your id");
			responseStructure2.setStatusData(list);
		}
		
		return responseStructure2;
	}
	
	public ResponseStructure<List<Student>> getAllStudentOnly4DigitsIdService(){
		
		List<Student> list=studentDao.getAllStudentOnly4DigitsIdDao();
		
		System.out.println(list);
		List<Student> filters = new ArrayList<Student>();
		
		if(!(list.isEmpty())) {
			
			for (Student student : list) {
				int id = student.getStudentId();
				if(id>999&&id<10000) {
					filters.add(student);
					responseStructure2.setStatusCode(HttpStatus.FOUND.value());
					responseStructure2.setStatusMessage("data-is-not--found");
					responseStructure2.setStatusDescription("please check your id");
					responseStructure2.setStatusData(filters);
				}else {
					responseStructure2.setStatusCode(HttpStatus.NOT_FOUND.value());
					responseStructure2.setStatusMessage("no id with 4 digits available ");
					responseStructure2.setStatusDescription("please check your id");
					responseStructure2.setStatusData(filters);
				}
			}
			
			
		}else {
			responseStructure2.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure2.setStatusMessage("there is not data in table");
			responseStructure2.setStatusDescription("please check your id");
			responseStructure2.setStatusData(list);
		}
		
		return responseStructure2;
	}
	
	public Student findByStudentEmailService(String studentEmail) {
		return studentDao.findByStudentEmailDao(studentEmail);
	}
	
	public void deleteByStudentService(int studentId) {
		studentDao.deleteByStudentIdDao(studentId);
	}
	
//	public boolean updateStudentNameByIdService(Student studentId) {
////		return studentDao.updateStudentNameByIdDao(studentId);
//	}
//	
}
