package com.jsp.springbootcrudoprationwithjunit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DataJpaTest
//kisi class ko junit class configretion banane ke liye @data jpa ka use karte hai
class SpringBootCrudOprationwithJunitApplicationTests {

	@Test
	void contextLoads() {
	}

}
