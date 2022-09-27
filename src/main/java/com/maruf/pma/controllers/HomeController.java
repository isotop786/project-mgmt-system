package com.maruf.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.maruf.pma.dao.ProjectRepository;
import com.maruf.pma.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	ProjectRepository projectRepo;
	
	@GetMapping("")
	public String displayHome(Model model)
	{
		List<Project> projects = projectRepo.findAll();
		
		model.addAttribute("projects",projects);
		
		return "main/home";
	}
}
