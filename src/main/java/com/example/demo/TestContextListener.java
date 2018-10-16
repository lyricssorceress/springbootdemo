package com.example.demo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.stereotype.Component;

@Component
public class TestContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Context loaded");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Context destroyed");
	}

}
