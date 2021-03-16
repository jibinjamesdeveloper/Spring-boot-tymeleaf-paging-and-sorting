package com.jibinemployee.jibinemployee.service;

import com.jibinemployee.jibinemployee.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmplpoyees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    void deleteEmployeeById(Long id);

}
