package com.atos.api.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.api.model.User;
import com.atos.api.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class RegisterService {

	@Autowired
	private UserRepository userRepository;

	public boolean addUser(User user) {
		String name = user.getUserName();
		LocalDate birthDate = user.getBirthDate();
		String country = user.getCountry();

		if (name == null || birthDate == null || country == null)
			return false;

		long age = ChronoUnit.YEARS.between(birthDate, LocalDate.now());

		if (age >= 18 && country.equalsIgnoreCase("France")) {
			userRepository.save(user);
			return true;
		}
		return false;
	}

}