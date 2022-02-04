package com.atos.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.atos.api.service.DisplayService;

@SpringBootTest
public class UserDisplayServiceTest {

	@Autowired
	DisplayService displayService;

	// Don't know how to mock a repository
}
