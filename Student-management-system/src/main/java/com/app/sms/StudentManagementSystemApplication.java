package com.app.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.sms.entity.Student;
import com.app.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
@Autowired
private StudentRepository studentRepository;

public void run(String...args)throws Exception{
	
	Student student1= new Student("Kajal","Pawar","kajal@123");
	studentRepository.save(student1);
}
//	
//	
//	
//	

}


