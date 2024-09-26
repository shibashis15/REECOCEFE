package com.hdfcLogin.demo.repository;

import com.hdfcLogin.demo.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
    Optional<State> findByStateName(String state);

    Optional<State> findByCountryCode(Long countryID);
}
