package com.fbs.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fbs.demo.entity.Employee;
import com.fbs.demo.service.EmpService;


@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;

	@GetMapping("/")
	public String home(org.springframework.ui.Model m)
	{
		
		List<Employee> emp=service.getAllEmp();
		
		m.addAttribute("emp",emp);
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmpForm()
	{
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e)
	{
		System.out.println(e);
		
		service.addEmp(e);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, org.springframework.ui.Model m) 
	{
		Employee e=service.getEmpById(id);
		
		m.addAttribute("emp",e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e)
	{
		service.addEmp(e);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id)
	{
		service.deleteEmp(id);
		return "redirect:/";
	}
}
