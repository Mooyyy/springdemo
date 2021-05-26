package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomePage(Model model, String keyword) {
		if(keyword != null) {
			model.addAttribute("listEmployees", employeeService.findByKeyword(keyword));
		}
		else {
			model.addAttribute("listEmployees", employeeService.getAllEmployee());
		}
		return "index";
	}
	@GetMapping("/showAddNewEmployeeForm")
	public String showAddNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "addEmployee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value="id") long id, Model model) {
		Employee employee = employeeService.getEmployeebyID(id);
		model.addAttribute("employee", employee);
		return "updateEmployee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployeeByID(@PathVariable(value="id") long id, Model model) {
		this.employeeService.deleteEmployeeByID(id);
		return "redirect:/";
	}
}
