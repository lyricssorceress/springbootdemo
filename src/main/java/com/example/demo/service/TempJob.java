package com.example.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TempJob {
	
	@Scheduled(cron = "0 26 21 * * ?")
	public void commit() {
		System.out.println("I am gets runned");
	}
}
