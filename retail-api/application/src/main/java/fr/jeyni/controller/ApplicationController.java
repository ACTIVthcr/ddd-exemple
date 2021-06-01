package fr.jeyni.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

	@GetMapping(path = "/hello")
	public String hello() {
		return "hello";
	}
}
