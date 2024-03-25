package com.jsp.springbootsimpleprojectcrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "getSubject")
public class SubjectController {

	@GetMapping(value = "/myData")
	public String getData() {
		return "send my Data";
	}
}
