package com.example.demo.branch;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.demo.project.Project;


@Entity
public class Branch 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	@ManyToOne
	private Project project;
	
	public Branch()
	{
		
	}
	
	public Branch(int id, String name, int projectId) 
	{
		super();
		this.id = id;
		this.name = name;
		this.project = new Project(projectId, " ", " ");
	}
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public Project getProject() 
	{
		return project;
	}

	public void setProject(Project project) 
	{
		this.project = project;
	}

	
	
}
