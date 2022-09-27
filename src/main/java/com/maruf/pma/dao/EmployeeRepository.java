package com.maruf.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.maruf.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
