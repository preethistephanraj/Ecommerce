package com.niit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller

public class HomeController {
public HomeController() {
	System.out.println("HomrController bean is created");
}	
	@RequestMapping("/")
	public String getHomePage() {
		System.out.println("home page");
		return "header";
	}

}
