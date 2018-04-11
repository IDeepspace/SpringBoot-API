package com.springbootapi.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
public class EmployeeControlllor {

  @Autowired
  private EmployeeRepository employeeRepository;

  //查询所有employee列表
  @GetMapping(value = "/employees")
  public List<Employee> employeeList() {
    return employeeRepository.findAll();
  }

  //新增一名employee
  @PostMapping(value = "/employees")
  public Employee employeeAdd(@RequestParam("name") String name,
                            @RequestParam("age") Integer age,
                            @RequestParam("gender") String gender) {

    Employee employee = new Employee();

    employee.setName(name);
    employee.setAge(age);
    employee.setGender(gender);

    return employeeRepository.save(employee);

  }

//  //查询一名employee
//  @GetMapping(value = "/employees/${id}")
//  public Employee employeeFindOne(@PathVariable("id") Integer id) {
//    return employeeRepository.getOne(id);
//  }
}
