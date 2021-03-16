package com.jibinemployee.jibinemployee.controller;

import com.jibinemployee.jibinemployee.model.Employee;
import com.jibinemployee.jibinemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //display list of emplyees
    @GetMapping("/")
    public String viewHomePage(Model model)
    {
        model.addAttribute("listEmployees",employeeService.getAllEmplpoyees());
        return "index";
    }
    
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model)
    {   //Create model attribute to bind data
    	Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "new_employee";
    	
    }
    
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee")Employee employee)
    {
    	// save employee to database 
    	 employeeService.saveEmployee(employee);
    	 return "redirect:/";
    }
    
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id")long id, Model model)
    {
    	// get employee from service
    	Employee employee = employeeService.getEmployeeById(id);
    	// set employee as a model to pre - populate the form 
    	model.addAttribute("employee",employee);  
		return "update_employee";
    	
    }
    
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value="id")long id)
    {
    	// Call delete employee method
    	employeeService.deleteEmployeeById(id);
    	 return "redirect:/";
    }
}
