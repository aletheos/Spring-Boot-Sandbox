package org.neocities.aletheos.springbootcamp.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class MoeController {
	private String getGreeting() {
		return "Hello";
	}

	private String getMeow() {
		return ":3";
	}

	@GetMapping("/")
	public String getPageIndex() {
		return String.format("%s %s", getGreeting(), getMeow());
	}

	@GetMapping("/{code}")
	public String getStatus(@PathVariable Integer code){
		ResponseEntity<String> response = null;
		try {
			response = ResponseEntity.status(code).build();
		} catch (IllegalArgumentException _) {
			return String.format("%s %s %s", getGreeting(), "silly, that's not an HTTP status code.", getMeow());
		}
		return String.format("%s %s", response.getStatusCode(), getMeow());
	}

	@GetMapping("/hello {name}")
	public String getName(@PathVariable String name) {
		return String.format("%s %s %s", getGreeting(), name, getMeow());
	}
}
