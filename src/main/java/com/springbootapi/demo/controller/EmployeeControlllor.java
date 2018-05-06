package com.springbootapi.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.springbootapi.demo.model.Employee;
import com.springbootapi.demo.dataSource.EmployeeRepository;

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

  //查询一名employee
  @GetMapping(value = "/employees/{id}")
  public Employee employeeFindOne(@PathVariable("id") Integer id) {
    return employeeRepository.findById(id).get();
  }

  //更新一名employee的信息
  @PutMapping(value = "/employees/{id}")
  public Employee employeeUpdate(@PathVariable("id") Integer id,
                                @RequestParam("name") String name,
                                @RequestParam("age") Integer age,
                                @RequestParam("gender") String gender) {
    Employee employee = new Employee();
    employee.setId(id);
    employee.setName(name);
    employee.setAge(age);
    employee.setGender(gender);

    return employeeRepository.save(employee);
  }

  //删除一名employee
  @DeleteMapping(value = "/employees/{id}")
  public void employeeDelete(@PathVariable("id") Integer id) {
    System.out.println(id);
    employeeRepository.deleteById(id);
  }

  //通过年龄来查询employee列表
  @GetMapping(value = "/employees/age/{age}")
  public List<Employee> employeeListByAge(@PathVariable("age") Integer age) {
    return employeeRepository.findByAge(age);
  }
  
}
