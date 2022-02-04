package com.atos.api.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.api.model.User;
import com.atos.api.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class DisplayService {

	@Autowired
    private UserRepository userRepository;
	
	public Optional<User> getUser(String name, LocalDate date, String country) {
        return userRepository.findByUserNameAndBirthDateAndCountry(name, date,country);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

}