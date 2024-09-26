package com.hdfcLogin.demo.service;

import com.hdfcLogin.demo.model.Country;
import com.hdfcLogin.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public ResponseEntity saveCountry(Country country) {
        if(countryRepository.findById(country.getCountryCode()).isEmpty()
                || countryRepository.findByCountryName(country.getCountryName()).isEmpty()) {
            countryRepository.save(country);
            return ResponseEntity.ok("Country " + country.toString() + " Added");
        }
        return  ResponseEntity.ok("Country Already Present!!");
    }

    public ResponseEntity getCountryById(Long id) {
        Optional<Country> optionalCountry = countryRepository.findById(id);
        if(optionalCountry.isEmpty())
            return ResponseEntity.ok("No Country Exist");
        return ResponseEntity.ok(optionalCountry.get());
    }

    public List<Country> getAll() {
        return countryRepository.findAll();
    }
}
