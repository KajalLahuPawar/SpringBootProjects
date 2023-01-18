package com.app.sms.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.app.sms.entity.Student;
import com.app.sms.repository.StudentRepository;
import com.app.sms.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

}
