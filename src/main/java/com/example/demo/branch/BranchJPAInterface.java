package com.example.demo.branch;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BranchJPAInterface extends CrudRepository<Branch, Integer>
{
	public List<Branch> findByProjectId(int projectId);
}
