package com.maruf.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.maruf.pma.dao.EmployeeRepository;
import com.maruf.pma.dao.ProjectRepository;
import com.maruf.pma.entities.Employee;
import com.maruf.pma.entities.Project;

@Controller
@RequestMapping(value="/employees")
public class EmployeeController {
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	ProjectRepository proRepo;
	
	@GetMapping("new")
	public String displayEmployeeForm(Model model)
	{
		List<Project> projects = proRepo.findAll();
		
		model.addAttribute("employee",new Employee());
		model.addAttribute("projects", projects);
		return "employee/new";
	}
	
	@PostMapping("save")
	public String saveEmployee(Model model, Employee employee, RedirectAttributes reAttr)
	{
		

		if(!employee.getFirstName().isEmpty() && !employee.getEmail().isEmpty())
		{
			empRepo.save(employee);
			reAttr.addFlashAttribute("success","Employee added successfully!");
			
			return "redirect:";
		}else {
			
			reAttr.addFlashAttribute("msg","Employee name and email can not be empty");
			
			return "redirect:new";
		}
	}
	
	@GetMapping("")
	public String getAllEmloyee(Model model)
	{
		List<Employee> employees = empRepo.findAll();
		
		model.addAttribute("employees", empRepo.findAll());
		
		return "employee/all";
	}
}
