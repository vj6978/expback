package com.example.demo.branch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.project.Project;

@RestController
public class BranchRestController
{
	
	@Autowired
	private BranchService branchService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/projects/{projectId}/branches")
	public List<Branch> getBranches(@PathVariable int projectId)
	{
		return branchService.getBranches(projectId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/projects/{projectId}/branches")
	public void addBranch(@PathVariable int projectId, @RequestBody Branch branchInfo)
	{
		branchInfo.setProject(new Project(projectId, " ", " "));
		branchService.addBranch(branchInfo);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/project/{projectId}/branches/{branchId}")
	public void updateBranch(@PathVariable int projectId, @RequestBody Branch branchInfo)
	{
		branchInfo.setProject(new Project(projectId, " ", " "));
		branchService.updateBranch(branchInfo);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/project/{projectId}/branches/{branchId}")
	public void deleteBranch(@PathVariable int branchId)
	{
		branchService.deleteBranch(branchId);
	}
}
