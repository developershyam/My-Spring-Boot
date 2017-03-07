package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.data.model.Employee;
import com.sample.service.EmployeeService;
/**
 * This is Rest controller used to expose URL for application to access Employee operations.
 * 
 * @author shyam.pareek
 *
 */
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/")
	public String home() {
		String api = "[ GET=>getEmployees], [ GET=>getEmployee/{id} ], [ POST=>addEmployee ], [ PUT=>updateEmployee ], [ DELETE=>deleteEmployee/{id} ]";
		return api;
	}

	@RequestMapping("/getEmployees")
	public List<Employee> getEmployees() {
		List<Employee> employeesList = employeeService.getEmployees();
		return employeesList;
	}

	@RequestMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable Long id) {

		return employeeService.getEmployee(id);
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {

		return employeeService.addEmployee(employee);
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee employee) {

		return employeeService.updateEmployee(employee);
	}

	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable Long id) {

		employeeService.deleteEmployee(id);

		return "Delete Success !!!";
	}

}
