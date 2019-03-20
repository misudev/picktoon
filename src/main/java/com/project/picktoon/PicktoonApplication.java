package com.project.picktoon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PicktoonApplication {

//	@Bean
//	public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver, SpringSecurityDialect sec) {
//		final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//		templateEngine.setTemplateResolver(templateResolver);
//		templateEngine.addDialect(sec); // Enable use of "sec"
//		templateEngine.addDialect(new LayoutDialect());
//		return templateEngine;
//	}

	public static void main(String[] args) {
		SpringApplication.run(PicktoonApplication.class, args);
	}



}
