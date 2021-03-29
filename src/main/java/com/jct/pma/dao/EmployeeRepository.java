package com.jct.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jct.pma.dto.EmployeeProject;
import com.jct.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{

//	@Override
//	public List<Employee> findAll();
	
	@Query(nativeQuery = true, value = "Select e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount "
			+ "From employee e left join project_employee pe ON pe.employee_id = e.employee_id "
			+ "Group by e.first_name, e.last_name ORDER BY 3 DESC")
	public List<EmployeeProject> employeeProjects();
}
