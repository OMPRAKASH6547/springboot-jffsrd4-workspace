package com.jsp.springbootsimpleprojectcrud.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentDaoTest {

	private final StudentDao dao = new StudentDao();
	
	@Test
	void addThreeNumberTest() {
		assertEquals(40, dao.addThreeNumber(10, 10, 10));
	}

}
