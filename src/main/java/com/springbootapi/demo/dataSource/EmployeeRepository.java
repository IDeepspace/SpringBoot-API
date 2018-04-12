package com.springbootapi.demo.dataSource;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<com.springbootapi.demo.model.Employee, Integer> {
  //通过年龄来查询
  public List<com.springbootapi.demo.model.Employee> findByAge(Integer age);
}
