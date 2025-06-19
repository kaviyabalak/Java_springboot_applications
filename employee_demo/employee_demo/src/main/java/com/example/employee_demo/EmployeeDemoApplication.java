package com.example.employee_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//(exclude = {
//org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class,
//org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class
//    })
@RestController
public class EmployeeDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeDemoApplication.class, args);
	}
	@GetMapping
	public String display(){
		return "hello world dd";
	}

}
