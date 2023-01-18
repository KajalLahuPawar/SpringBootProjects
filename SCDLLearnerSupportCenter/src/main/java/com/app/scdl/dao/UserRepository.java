package com.app.scdl.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.scdl.entities.AdminSignUp;


public interface UserRepository extends JpaRepository<AdminSignUp, Integer> {

}