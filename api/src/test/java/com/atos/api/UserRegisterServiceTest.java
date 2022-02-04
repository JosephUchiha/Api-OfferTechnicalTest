package com.atos.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.atos.api.model.User;
import com.atos.api.service.RegisterService;

@SpringBootTest
public class UserRegisterServiceTest {

	@Autowired
	RegisterService registerService;
	
	@Test
	public void testAddUserFailed() {
		User user1 = new User("bob", LocalDate.of(1994, 5, 11), "USA");
		assertThat(registerService.addUser(user1)).isFalse();
		
		User user2 = new User("bob", LocalDate.of(2010, 5, 11), "France");
		assertThat(registerService.addUser(user2)).isFalse();
	}
	
	@Test
	public void testAddUserSuccess() {
		User user1 = new User("bob", LocalDate.of(1994, 5, 11), "France");
		assertThat(registerService.addUser(user1)).isTrue();
		
		User user2 = new User("bob", LocalDate.of(2000, 5, 11), "France");
		assertThat(registerService.addUser(user2)).isTrue();
	}
}
