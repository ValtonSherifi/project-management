package com.jct.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jct.pma.dao.EmployeeRepository;
import com.jct.pma.dao.ProjectRepository;
import com.jct.pma.dto.ChartData;
import com.jct.pma.dto.EmployeeProject;
import com.jct.pma.entities.Employee;
import com.jct.pma.entities.Project;
import com.jct.pma.services.EmployeeService;
import com.jct.pma.services.ProjectService;

@Controller
public class HomeController {
	
	@Value("${version}")
	private String var;

	@Autowired
	ProjectService proService;

	@Autowired
	EmployeeService empService;

	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		model.addAttribute("versionNumber",var);

		Map<String, Object> map = new HashMap<>();

		// quering the database for projects
		List<Project> projects = proService.getAll();
		model.addAttribute("projects", projects);

		List<ChartData> projectData = proService.getProjectStatus();

		// lets conver projectData object into a json structure for use in javascript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		//[["NOTSTARTED", 1], ["INPROGRESS",2] ,["COMPLETED",3]]
		
		model.addAttribute("projectStatusCnt",jsonString);

		// quering the database for employees
		List<EmployeeProject> employeesProjectCnt = empService.employeeProjects();
		model.addAttribute("employeesListProjectsCnt", employeesProjectCnt);
		return "main/home";
	}
}
