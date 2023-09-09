package com.example.virtualpet.api.demo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[]args){
	var context = new SpringApplicationBuilder(ProjectConfig.class).web(WebApplicationType.SERVLET).run(args);
	}
}
