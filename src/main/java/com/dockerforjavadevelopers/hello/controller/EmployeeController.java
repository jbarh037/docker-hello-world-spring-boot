package com.dockerforjavadevelopers.hello.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dockerforjavadevelopers.hello.model.Employee;
import com.dockerforjavadevelopers.hello.service.EmployeeService;

// Controller -> Service -> Repository 
@RestController
@RequestMapping("/api")
public class EmployeeController {
    
    @Autowired // inject EmployeeService bean
    private EmployeeService employeeService;

    @GetMapping
    public String index() {
        return "Hello Worldddd\n";
    }
    // curl http://localhost:8080/api/employee/2
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        try {
            Optional<Employee> employee = employeeService.findEmployee(id);
            if (!employee.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(employee.get());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        try {
            List<Employee> list = employeeService.allEmployees();
            System.out.println("in the /employees method");
            System.out.println(list);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // curl -X POST http://localhost:8080/api/employee \
    //  -H "Content-Type: application/json" \
    //  -d '{"id": 2, "name": "John Doe", "age": 26}'
    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        try {
            employeeService.addEmployee(employee);
            Optional<Employee> added = employeeService.findEmployee(employee.getId());
            return ResponseEntity.ok(added.get());            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // curl -X DELETE http://localhost:8080/api/employee/2
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Void> removeEmployee(@PathVariable Long id) {
        try {
            employeeService.removeEmployee(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // TODO: handle exception and log error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
