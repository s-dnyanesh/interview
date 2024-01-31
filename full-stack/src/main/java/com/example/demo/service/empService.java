package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
@Service
public class empService {
	
	private final List<Employee> list= new ArrayList<>();
	public empService() {
		
		list.add(new Employee("Soham"));
		list.add(new Employee("Rohan"));
		list.add(new Employee("Mohan"));
	}
	public List<Employee> getAllemployees(){
		return list;
	}

}
