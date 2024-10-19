package com.jony.controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AgeController {

	@GetMapping("/")
	public String homePage() {

		return "index";
	}

	@PostMapping("/ages")
	public String calculateAge(@RequestParam String dob, Model model) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
		LocalDate birthDate = LocalDate.parse(dob, formatter);
	
		// Get the current date
		LocalDate currentDate = LocalDate.now();

		// Calculate the age
		Period age = Period.between(birthDate, currentDate);
	
		System.out.println("Your age is: " + age.getYears() + " years, " + age.getMonths() + " months, and "
				+ age.getDays() + " days.");
		
		model.addAttribute("day", age.getDays());
		model.addAttribute("month", age.getMonths());
		model.addAttribute("year", age.getYears());

		return "res";

	}

}
