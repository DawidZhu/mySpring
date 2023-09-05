package com.example.myangular.service;

import com.example.myangular.exception.UserNotFoundException;
import com.example.myangular.model.Employee;
import com.example.myangular.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    //新增，调用 save()方法
    public Employee addEmpolyee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    // 查询所有 findAll()
    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    // 更新，还是调用 save() 方法
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    // 根据ID删除， deleteById
    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }

    // 根据ID查找 findById
    public Employee findEmployeeById(Long id){
       // return employeeRepo.findById(id).get();
        return employeeRepo.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("User by id: " + id +" was not found"));
    }

}
