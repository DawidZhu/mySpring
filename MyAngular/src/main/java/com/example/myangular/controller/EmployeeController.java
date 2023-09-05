package com.example.myangular.controller;

import com.example.myangular.model.Employee;
import com.example.myangular.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 返回： ResponseEntity
     * ResponseEntity类，扩展了HttpEntity类，新增了status成员变量，
     * 这样，一个ResponseEntity基本可以代表完整的http的请求或响应了
     */
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employeeList = employeeService.findAllEmployee();
        return new ResponseEntity<>(employeeList, HttpStatus.OK); //200
    }

    /**
     * 根据ID 查询
     * @ PathVariable("id")
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK); //200
    }
    /**
     * 新增
     * 获取Json 类型的对象  @RequestBody
     */
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployees(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmpolyee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED); // 201
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployees(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK); //200
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployees(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
