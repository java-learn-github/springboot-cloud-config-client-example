package com.processor.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.processor.exceptions.DataNotFoundException;
import com.processor.exceptions.FileNotWriteException;
import com.processor.service.EmpService;

@RestController
public class EmpController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmpService empService;

	@GetMapping("/")
	public List<String> get() throws InterruptedException, IOException, ExecutionException {
		logger.info("EmpController.get() enter");
		List<String> path = null;
		long startTime = System.currentTimeMillis();

		try {
			List<Map<String, Object>> allData = empService.getAllData();

			path = (List<String>) empService.write(allData);

		} catch (DataNotFoundException | FileNotWriteException ex) {
			String handleMyException = ex.handleMyException();
			System.out.println(handleMyException);
		}
		long endTime = System.currentTimeMillis();
		
		logger.info("Total time :: {}ms", endTime - startTime);
		logger.info("EmpController.get() exit");

		return path;
	}

}
