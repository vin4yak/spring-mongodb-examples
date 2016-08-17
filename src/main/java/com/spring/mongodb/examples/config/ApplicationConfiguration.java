package com.spring.mongodb.examples.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableMongoRepositories("com.spring.mongodb.examples.repository")
@ComponentScan(basePackages = { "com.spring.mongodb.examples" }, useDefaultFilters = false, excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = ApplicationConfiguration.class) }, includeFilters = {
				@ComponentScan.Filter(type = FilterType.ANNOTATION, value = { Controller.class, Component.class }) })
public class ApplicationConfiguration {

}
