package com.jct.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jct.pma.dao.EmployeeRepository;
import com.jct.pma.dao.ProjectRepository;
import com.jct.pma.entities.Employee;
import com.jct.pma.entities.Project;

@Controller
public class HomeController {

	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects", projects);
		
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employees", employees);
		return "main/home";
	}
}
