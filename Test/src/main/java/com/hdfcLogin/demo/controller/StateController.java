package com.hdfcLogin.demo.controller;

import com.hdfcLogin.demo.model.State;
import com.hdfcLogin.demo.repository.StateRepository;
import com.hdfcLogin.demo.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/state")
public class StateController {
    @Autowired
    private StateService stateService;

    @GetMapping
    public ResponseEntity allState() {
        return stateService.getAllState();
    }

    @GetMapping("/all")
    public ResponseEntity getAll(@RequestParam Long countryCode) {
        return stateService.getAllStatesByCountry(countryCode);
    }

    @PostMapping
    public ResponseEntity addState(@RequestBody State state) {
        return stateService.addState(state);
    }
}
