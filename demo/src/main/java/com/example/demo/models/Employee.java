package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class Employee {
	
	private String empId;
	private String empname;
	private String gender;
	private String deptId;
	private int age;
	private int salary;
	private int yearOfJoining;

}
