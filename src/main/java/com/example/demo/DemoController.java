package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class); 

	@GetMapping("/test")
	public void test() {
		LOGGER.info("test() envoked");
	}	
}
