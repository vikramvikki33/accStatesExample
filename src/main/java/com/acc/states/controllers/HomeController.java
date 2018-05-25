package com.acc.states.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acc.states.services.StatesService;

@Controller
@RequestMapping("/")
public class HomeController {

	private StatesService service;
	
	
	public HomeController(StatesService service) {
		this.service = service;
	}

	@GetMapping
	public String home(Model model) {
		model.addAttribute("message", "This is Home of States Application");
		this.service.AddStates();
		return "index";
	}
	
	@GetMapping("/findAll")
	public String findAllStates(Model model) {
		model.addAttribute("states", this.service.findAllStates());
		return "index";
	}
	
	
	
}
