package com.jibinemployee.jibinemployee.serviceImpl;

import com.jibinemployee.jibinemployee.model.Employee;
import com.jibinemployee.jibinemployee.repository.EmployeeRepository;
import com.jibinemployee.jibinemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmplpoyees() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee Not Found for id :: " + id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(Long id) {

		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employeeRepository.deleteById(id);
		} else
			throw new RuntimeException(" Employee Not Found for id to delete:: " + id);
	}

}
