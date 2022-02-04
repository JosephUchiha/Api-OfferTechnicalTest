package com.atos.api.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atos.api.model.User;
import com.atos.api.service.DisplayService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserDisplayController {

	@Autowired
	DisplayService displayService;

	@GetMapping("/display")
	@RequestMapping(value = "/display", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "User succesfully displayed"),
			@ApiResponse(code = 400, message = "Cannot display unregistered user") })
	public String displayUser(String name, LocalDate date, String country) {
		Optional<User> opt = displayService.getUser(name, date, country);
		if (opt.isPresent()) {
			return opt.get().toString();
		}
		return "User not found";
	}
}
