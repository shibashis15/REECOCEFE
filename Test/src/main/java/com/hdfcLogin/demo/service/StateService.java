package com.hdfcLogin.demo.service;

import com.hdfcLogin.demo.model.State;
import com.hdfcLogin.demo.repository.CountryRepository;
import com.hdfcLogin.demo.repository.StateRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryRepository countryRepository;

    public ResponseEntity getAllStatesByCountry(Long countryID) {
        Optional<State> stateOptional = stateRepository.findByCountryCode(countryID);
        if(stateOptional.isEmpty())
            return ResponseEntity.ok("Country Code Invalid");
        return ResponseEntity.ok(stateRepository.findByCountryCode(countryID));
    }

    public ResponseEntity getAllState() {
        return ResponseEntity.ok(stateRepository.findAll());
    }

    public ResponseEntity addState(State state) {
        if(countryRepository.findById(state.getCountryCode()).isEmpty()) {
            return ResponseEntity.ok("Enter Valid State");
        }
        return ResponseEntity.ok(stateRepository.save(state));
    }
}
