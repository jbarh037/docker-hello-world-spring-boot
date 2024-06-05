package com.dockerforjavadevelopers.hello.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dockerforjavadevelopers.hello.model.Employee;
import com.dockerforjavadevelopers.hello.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    public Optional<Employee> findEmployee(Long id) {
        return Optional.ofNullable(employeeRepository.findEmployee(id));
    }

    public List<Employee> allEmployees() {
        return employeeRepository.allEmployees();
    }

    public void removeEmployee(Long id) {
        employeeRepository.removeEmployee(id);
    }
    
}
