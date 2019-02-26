package com.tangoe.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tangoe.spring.bean.Employee;

/**
 * 
 * @author Manish.Barnawal
 * 
 * This interface provides an abstraction of all crud operation for
 * Employee.
 *
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
