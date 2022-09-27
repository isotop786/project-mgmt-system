package com.maruf.pma.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.maruf.pma.dao.ProjectRepository;
import com.maruf.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	 
	@Autowired
	ProjectRepository projectRepo;
	
	@RequestMapping(value="new", method = RequestMethod.GET)
	public String displayProjectForm(Model model)
	{
		model.addAttribute("project", new Project());
		
		return "new-project";
	} 
	
	@RequestMapping(value ="save", method = RequestMethod.POST)
	public String saveProject(Project project, Model model, RedirectAttributes reAttr)
	{
		projectRepo.save(project); 
		
//		reAttr.addFlashAttribute("project", project);
		//reAttr("project", project);
				
		// use a redirect to prevent duplicate submission
		return "redirect:new";
	}
	
	@RequestMapping(value="all", method = RequestMethod.GET)
	public String getAllProjcet()
	{
		System.out.println("all projects: "+projectRepo.findAll().getClass());
		
		List<Project> projects = (List<Project>) projectRepo.findAll();
		
//		System.out.println(projects);
		for(Project pro: projects)
			System.out.println(pro.getName());
		
		
		return "all";
	}
	
	
	
}
 