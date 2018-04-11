package com.springbootapi.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<com.springbootapi.demo.Employee, Integer> {

}
