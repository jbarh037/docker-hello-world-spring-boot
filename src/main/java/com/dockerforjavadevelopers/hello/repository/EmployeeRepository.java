package com.dockerforjavadevelopers.hello.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.dockerforjavadevelopers.hello.model.Employee;
import com.sun.tools.javac.util.List;

@Repository
public class EmployeeRepository {
    private HashMap<Long, Employee> employeeDB = new HashMap<>();

    public Employee addEmployee(Employee employee) {
        employeeDB.put(employee.getId(), employee);
        return employee;
    }

    public Employee findEmployee(Long id) {
        return employeeDB.get(id);
    }

    public List<Employee> allEmployees() {
        return (List<Employee>) employeeDB.values();
    }

    public void removeEmployee(Long id) {
        employeeDB.remove(id);
    }
    
}
