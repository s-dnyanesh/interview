package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.empService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class EmpoyeeController {
	
	private final empService eempService = new empService();
	@RequestMapping("/getall")
	public List<Employee> getAllEmployees(){
		
		
		
		return eempService.getAllemployees();
	}
	


}
