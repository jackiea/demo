package com.youkol.demo.dockerlayer;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class DockerLayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerLayerApplication.class, args);
	}

	@RestController
	public static class TestController {
	
		@RequestMapping(value = "/hello")
		public String hello() {
			return "Hello " + LocalDateTime.now();
		}
		
	}

}
