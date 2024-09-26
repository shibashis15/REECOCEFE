package com.hdfcLogin.demo.service;

import com.hdfcLogin.demo.model.User;
import com.hdfcLogin.demo.repository.CountryRepository;
import com.hdfcLogin.demo.repository.StateRepository;
import com.hdfcLogin.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private CountryRepository countryRepository;
    private StateRepository stateRepository;

    @Autowired
    public UserService(UserRepository userRepository, CountryRepository countryRepository, StateRepository stateRepository) {this.userRepository = userRepository;
    this.countryRepository = countryRepository;
    this.stateRepository = stateRepository;
    }

    @Transactional
    public ResponseEntity saveUser(User user) {

        if(userRepository.existsById(user.getId()))
            return ResponseEntity.ok("User already Exist!");

        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setState(user.getState());
        newUser.setCountry(user.getCountry());
        String country = newUser.getCountry();
        String state = newUser.getState();
        state = state.toLowerCase();

        if(countryRepository.findByCountryName(country).isEmpty() || stateRepository.findByStateName(state).isEmpty()) {
            return ResponseEntity.ok("Invalid Sate or Country !!");
        }
        userRepository.save(user);
        return ResponseEntity.ok("User added!" + newUser.toString());
    }

    public ResponseEntity getAll() {
        return ResponseEntity.of(Optional.of(userRepository.findAll()));
    }

}
