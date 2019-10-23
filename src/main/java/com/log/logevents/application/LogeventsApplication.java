package com.log.logevents.application;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.log.logevents.application.Controller.LogEventsController;


/**
 * 
 * @author Akansha Karwa
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class LogeventsApplication implements CommandLineRunner{

	@Autowired
	LogEventsController logEventController;
	
	private Scanner scanner;
	
	public static void main(String[] args) {
		SpringApplication.run(LogeventsApplication.class, args);
	}

	/**
	 * This method is entry point for application
	 */
	@Override
	public void run(String... args) throws Exception 
	{
		scanner = new Scanner(System.in);

		System.out.println("===================================================================\n");
		
	    System.out.print("Enter location of your log file: ");
	    
	    String logFilePath = scanner.next();
	    
	    System.out.println("===================================================================\n");

		logEventController.analyze(logFilePath);
	}

}
