package com.example.demo.project;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectRestController 
{
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping(value = "/welcome")
	public ResponseEntity<String> showWelcomeMessage()
	{
		return ResponseEntity.ok("This project is authored by Vimal James");
	}
	
	@GetMapping(value = "/projects")
	public ResponseEntity<List> getProjects()
	{
		return ResponseEntity.ok(projectService.getProjects());
	}
	
	@GetMapping(value = "/projects/{projectId}")
	public ResponseEntity<Project> getProject(@PathVariable int projectId)
	{
		Optional<Project> project = projectService.getProjectById(projectId);
		
		if(project.isPresent())
		{
			return new ResponseEntity<Project>(project.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/projects")
	public ResponseEntity<Project> addProject(@RequestBody Project projectInfo)
	{
		return new ResponseEntity<Project>(projectService.addProject(projectInfo), HttpStatus.OK);
	}
	
	@PutMapping(value = "/projects/{projectId}")
	public ResponseEntity<Project> updateProject(@RequestBody Project projectInfo, @PathVariable int projectId)
	{
		Optional<Project> project = projectService.getProjectById(projectId);
		
		if(project.isPresent())
		{
			return new ResponseEntity<Project>(projectService.updateProject(projectInfo), HttpStatus.OK);
		}
		
		return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "/projects/{projectId}")
	public void deleteProject(@PathVariable int projectId)
	{
		projectService.deleteProject(projectId);
	}
}
