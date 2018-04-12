package com.springbootapi.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  //通过年龄来查询
  public List<Employee> findByAge(Integer age);
}
