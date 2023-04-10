package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/string")
	public String string() {
		return "string";
	}

	@GetMapping("/list")
	public List<String> list() {
		return List.of("Messi", "Ronaldo", "Neymar");
	}

	@GetMapping("/map")
	public Map<String, Integer> map() {
		return Map.of("messi", 35, "ronaldo", 38, "neymar", 31);
	}
}
