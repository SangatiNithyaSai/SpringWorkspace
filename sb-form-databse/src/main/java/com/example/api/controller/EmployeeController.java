package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.api.repository.EmployeeRepository;
import com.example.api.user.Employee;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeData;
	

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
	public String newEmployee(Employee employee) {

	 employeeData.save(employee);
		return ("redirect:/listEmployees");

	}

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.GET)
	public ModelAndView addNewEmployee() {

		Employee emp = new Employee();
		return new ModelAndView("newEmployee", "form", emp);

	}

	@RequestMapping(value = "/listEmployees", method = RequestMethod.GET)
	public ModelAndView employees(){
		List<Employee> allEmployees = employeeData.findAll();
		return new ModelAndView("allEmployees", "employees", allEmployees);

	}

}
