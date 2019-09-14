package com.example.demo.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService 
{
	
	@Autowired
	private ProjectJPAInterface projectJPA;
	
	public List<Project> getProjects()
	{
		List<Project> allProjects = new ArrayList<Project>();
		Iterable<Project> projectIterator = projectJPA.findAll();
		
		for(Project project : projectIterator)
		{
			allProjects.add(project);
		}
		
		return allProjects;
	}
	
	public Optional<Project> getProjectById(int projectId)
	{
		Optional<Project> project = projectJPA.findById(projectId);		
		
		return project;
	}
	
	public Project addProject(Project project)
	{
		return projectJPA.save(project);
	}
	
	public Project updateProject(Project project)
	{
		return projectJPA.save(project);
	}
	
	public void deleteProject(int projectId)
	{
		projectJPA.deleteById(projectId);
	}
}
