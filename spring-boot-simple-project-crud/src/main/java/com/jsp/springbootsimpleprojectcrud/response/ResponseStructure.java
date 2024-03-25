package com.jsp.springbootsimpleprojectcrud.response;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ResponseStructure<T> {
	
	private int statusCode;
	private String statusMessage;
	private String statusDescription;
	private T statusData;
	
	
}
