package com.lts.FBA.FlightBookingApplication.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping(path = "/")
	public String homePage()
	{
		return "This is home page.";
	}
}
