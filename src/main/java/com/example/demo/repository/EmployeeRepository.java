package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Employee;

//JpaRepository - performs CRUD

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query(value="select * from employee e where e.first_name like %:keyword% or e.last_name like %:keyword%", nativeQuery = true)
	List<Employee> findByKeyword(@Param("keyword") String keyword);
	
}
