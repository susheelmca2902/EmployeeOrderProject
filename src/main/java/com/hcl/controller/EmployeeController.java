package com.hcl.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.model.Address;
import com.hcl.model.Employee;
import com.hcl.service.EmployeeService;

@Controller
public class EmployeeController {
	private static final Logger logger = Logger.getLogger(EmployeeController.class);

	public EmployeeController() {
		logger.info("Employee Controller");
	}

	@Autowired
	private EmployeeService employeeService;
	
/*	@InitBinder
	public void initBinder(WebDataBinder binder) {
		logger.info("InitBinder strted");
		SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dateFormat, false));
		logger.info("InitBinder completed");
	}*/

	@RequestMapping(value = "/")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		logger.info("List of Employee started");
		List<Employee> listEmployee = employeeService.getAllEmployee();
		model.addObject("listEmployee", listEmployee);
		model.setViewName("home");
		logger.info("List of Employee Completed "+listEmployee);
		return model;
	}

	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newEmployee(ModelAndView model) {
		Employee employee = new Employee();
		model.addObject("employee", employee);
		model.setViewName("EmployeeForm");
		logger.info("new Employee methed completed");
		return model;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@Valid @ModelAttribute Employee employee, BindingResult result) {
		System.out.println("at the time of  Save ");
		if (result.hasErrors()) {
			return new ModelAndView("EmployeeForm");
		} else {
			if (employee.getId() == 0) {
				employeeService.addEmployee(employee);
			} else {
				employeeService.updateEmployee(employee);
			}
			return new ModelAndView("redirect:/");
		}
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeService.getEmployee(employeeId);
		ModelAndView model = new ModelAndView("EmployeeForm");
		model.addObject("employee", employee);
		return model;
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		employeeService.deleteEmployee(employeeId);
		return new ModelAndView("redirect:/");
	}
}
