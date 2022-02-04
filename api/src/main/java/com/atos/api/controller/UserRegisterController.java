package com.atos.api.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atos.api.model.User;
import com.atos.api.model.User.Gender;
import com.atos.api.service.RegisterService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserRegisterController {
	
	@Autowired
	RegisterService registerService;

	@RequestMapping(value="/register", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value= {
			@ApiResponse(code=201, message="User succesfully registred"),
			@ApiResponse(code=412, message="Cannot register user")
	})
	public ResponseEntity<String> registerUser(String name, String date, String country, String gender, String phone) {
		
		LocalDate localDate=null;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			localDate = LocalDate.parse(date, formatter);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
		}
		
		Gender genderValue = null;
		try {
		genderValue = User.Gender.valueOf(gender);
		}catch(Exception e) {
			// Nothing
		}
		
		User user = new User(name, localDate, country, phone, genderValue);
		if(registerService.addUser(user)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
	}
}
