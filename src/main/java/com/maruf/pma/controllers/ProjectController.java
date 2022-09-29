package com.maruf.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.maruf.pma.dao.EmployeeRepository;
import com.maruf.pma.dao.ProjectRepository;
import com.maruf.pma.entities.Employee;
import com.maruf.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	 
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	EmployeeRepository empReop;
	
	@RequestMapping(value="new", method = RequestMethod.GET)
	public String displayProjectForm(Model model)
	{
		List<Employee> employees = empReop.findAll();
		
		
		model.addAttribute("project", new Project());
		
		model.addAttribute("allEmployee", employees);
		
		return "project/new-project";
	} 
	
	@RequestMapping(value ="save", method = RequestMethod.POST)
	public String saveProject(Project project, Model model, RedirectAttributes reAttr, @RequestParam List<Long> employee)
	{
		//System.out.println("Employees are: "+employee);
		projectRepo.save(project);
		
		Iterable<Employee> selectedEmployees = empReop.findAllById(employee);
		
		for(Employee emp: selectedEmployees) {
			emp.setProject(project);
			empReop.save(emp);
		}
			
		
		
				
		// use a redirect to prevent duplicate submission
		return "redirect:";
	}
	
	@GetMapping("")
	public String getAllProjcet(Model model)
	{
		List<Project> projects = projectRepo.findAll();
		
		model.addAttribute("projects",projects);
		
		return "project/all";
	}
	
	
	
}
 