package com.springbootapi.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
public class EmployeeControlllor {

  @Autowired
  private EmployeeRepository employeeRepository;

  @GetMapping(value = "/employees")
  public List<Employee> employeeList() {
    return employeeRepository.findAll();
  }
}
