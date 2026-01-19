package com.twg.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.twg.springboot.entities.Employee;
import com.twg.springboot.service.EmployeeService;


@Controller
public class HomeControllers {
	
	@Autowired
	private EmployeeService employeeService;
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@GetMapping("/")
	public String getHome(Model model) {
		Employee emp=new Employee();
		emp.setName("Ramya");
		emp.setExp(4);
		emp.setDesignation("Student");
		Employee employee=employeeService.saveEmployee(emp);
		model.addAttribute("emp",employee);
		String msg="Yes"+employee.getName()+"with id"+employee.getId()+"successfully saved in the database";
		model.addAttribute("msg",msg);
		return "home";
		
	}
	
}
