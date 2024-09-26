package com.hdfcLogin.demo.controller;

import com.hdfcLogin.demo.model.Country;
import com.hdfcLogin.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/getAll")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(countryService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addCountry(@RequestBody Country country) {
        return countryService.saveCountry(country);
    }

    @GetMapping("/getById")
    public ResponseEntity getCountry(@RequestParam Long countryId) {
        return countryService.getCountryById(countryId);
    }

}
