package com.maruf.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maruf.pma.dao.EmployeeRepository;
import com.maruf.pma.dao.ProjectRepository;
import com.maruf.pma.entities.Employee;
import com.maruf.pma.entities.Project;

@Controller
@RequestMapping("")
public class HomeController {
	
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("")
	public String displayHome(Model model)
	{
		List<Project> projects = projectRepo.findAll();
		List<Employee> employees = empRepo.findAll();
		
		model.addAttribute("projects",projects);
		model.addAttribute("employees",employees);
		
		return "main/home";
	}
}
