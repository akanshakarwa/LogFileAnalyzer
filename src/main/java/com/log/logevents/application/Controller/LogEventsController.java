package com.log.logevents.application.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.log.logevents.application.Service.LogEventsService;

/**
 * 
 * @author Akansha Karwa
 *
 */
@Controller
public class LogEventsController 
{
	@Autowired
	LogEventsService service;
	
	Logger logger = LoggerFactory.getLogger(LogEventsController.class);

	/**
	 * Calls service method to analyze logs
	 * @param filePath
	 */
	public void analyze(String filePath) 
	{
		logger.debug("File path that is processed : ",filePath);
		if(service.analyzeLogFile(filePath))
		{
			logger.info("********** Log Analyzed Successfully *********");
		}
		else
		{
			logger.info("********** Log Analyzed Failed *********");
		}
	}
}
