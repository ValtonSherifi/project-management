package com.jct.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jct.pma.dto.ChartData;
import com.jct.pma.entities.Project;

public interface ProjectRepository extends PagingAndSortingRepository<Project,Long>{
	
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery = true, value = "Select stage as label, COUNT(*) as value "
			+ "from project "
			+ "group by stage")
	public List<ChartData> getProjectStatus();
	
}
