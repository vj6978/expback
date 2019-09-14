package com.example.demo.branch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService 
{
	
	@Autowired
	private BranchJPAInterface branchJPA;
	
	public List<Branch> getBranches(int projectId)
	{
		return branchJPA.findByProjectId(projectId);
	}
	
	public void addBranch(Branch branchInfo)
	{
		branchJPA.save(branchInfo);
	}
	
	public void updateBranch(Branch branchInfo)
	{
		branchJPA.save(branchInfo);
	}
	
	public void deleteBranch(int branchId)
	{
		branchJPA.deleteById(branchId);
	}
}
