package com.collegemanagement.collegemanagement;

import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class CollegemanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegemanagementApplication.class, args);
	}

}
