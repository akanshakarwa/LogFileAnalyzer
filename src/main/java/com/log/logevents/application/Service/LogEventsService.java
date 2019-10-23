package com.log.logevents.application.Service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.log.logevents.application.Model.EventDetails;
import com.log.logevents.application.Model.Log;
import com.log.logevents.application.Repository.LogEventsRepository;

/**
 * 
 * @author Akansha Karwa
 *
 */
@Service
public class LogEventsService 
{
	@Autowired
	LogEventsRepository repo;
	
	Logger logger = LoggerFactory.getLogger(LogEventsService.class);

	/**
	 * 
	 * @param filePath
	 * @return
	 */
	public boolean analyzeLogFile(String filePath)
	{
		logger.debug("Entered method analyzeLogFile");
		ArrayList<JSONObject> json=new ArrayList<JSONObject>(); 
		JSONObject obj;
		try(FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);)
		{ 
			String line;
			while((line = bufferedReader.readLine()) != null) 
			{ 
				obj = (JSONObject) new JSONParser().parse(line); 
				json.add(obj);
			} 
			logger.debug("Size of Json List ->",json.size());
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Log>> typeReference = new TypeReference<List<Log>>(){};
			InputStream inputStream = new ByteArrayInputStream(json.toString().getBytes());
			List<Log> logData = mapper.readValue(inputStream,typeReference);
			logger.debug("Size of Log List after converting from Json  ->",logData.size());
			if(logData.size() > 0)
			{
				setresult(logData);
			}

		} 
		catch(IOException |ParseException  ex) 
		{ 
			logger.error("IOException/ParseException Occured in processing ->", ex.getMessage());
			return false;
		}
		catch(Exception ex)
		{
			logger.error("Exception Occured in processing ->",ex.getMessage());
			return false;
		}

		logger.debug("Exit method analyzeLogFile");
		return true;

	}

	/**
	 * Method to calculate time
	 * @param logData
	 */
	private void setresult(List<Log> logData)
	{
		logger.debug("Entered method setresult()");
		Set<String> uniqueId = new HashSet<>();
		logData.forEach(log -> uniqueId.add(log.getId()));
		List<EventDetails> taskForLongTime = new ArrayList<>();
		for(String a : uniqueId)
		{
			List<Log> log = logData.stream().filter(p -> p.getId().equals(a)).collect(Collectors.toList());
			long t1 = 0;
			long t2 = 0;
			for(Log l : log)
			{
				if("Started".equalsIgnoreCase(l.getState()))
				{
					t1 = l.getTimestamp();
				}
				if("FINISHED".equalsIgnoreCase(l.getState()))
				{
					t2 = l.getTimestamp();
				}
			}

			if(t1 > 0 && t2 > 0 && (t2 -t1) > 4)
			{
				EventDetails l1 = new EventDetails();
				l1.setAlert(true);
				l1.setEventId(log.get(0).getId());
				l1.setDuration(t2-t1);
				l1.setHost(log.get(0).getHost());
				l1.setType(log.get(0).getType());
				taskForLongTime.add(l1);
			}

		}
		logger.debug("Size of array for db storegare ->",taskForLongTime.size());
		if(taskForLongTime.size() > 0)
		{	
			repo.saveAll(taskForLongTime);
		}
		logger.debug("Exit method setresult()");
	}
}
