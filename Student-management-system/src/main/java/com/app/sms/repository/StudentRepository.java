package com.app.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.sms.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long> { 

}
