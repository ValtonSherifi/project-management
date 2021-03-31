package com.jct.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jct.pma.dto.ChartData;
import com.jct.pma.dto.TimeChartData;
import com.jct.pma.entities.Project;

@RepositoryRestResource(collectionResourceRel="apiprojects", path="apiprojects")
public interface ProjectRepository extends PagingAndSortingRepository<Project,Long>{
	
//	@Override
//	public List<Project> findAll();
	
	@Query(nativeQuery = true, value = "Select stage as label, COUNT(*) as value "
			+ "from project "
			+ "group by stage")
	
	public List<ChartData> getProjectStatus();
	
	public Project findByProjectId(long theId);
	
	@Query(nativeQuery = true, value = "SELECT name as projectName, start_date as startDate, end_date as endDate "
			+ "From project")
	public List<TimeChartData> getTimeData();
	
}
