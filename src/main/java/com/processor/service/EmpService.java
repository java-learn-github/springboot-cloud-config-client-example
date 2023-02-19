package com.processor.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.processor.constants.EmpConstants;
import com.processor.exceptions.DataNotFoundException;
import com.processor.exceptions.FileNotWriteException;
import com.processor.repository.EmpRepo;

@Component
public class EmpService {

	@Autowired
	EmpRepo empRepo;
	
	@Value("${systemValue}")
	String systemValue;
	
	@Value("${systemValue2}")
	String systemValue2;
	
	
	

	public List<Map<String, Object>> getAllData() throws DataNotFoundException {

		List<Map<String, Object>> allData = empRepo.getAllData();
		System.out.println("systemValue :: "+systemValue);
		System.out.println("systemValue :: "+systemValue2);
		if (allData.isEmpty()) {
			throw new DataNotFoundException();
		} else {
			return allData;
		}

	}

	public List<String> write(List<Map<String, Object>> allData) throws IOException, FileNotWriteException {
		List<String> pathList =new ArrayList<>();
		Path path = null;
		for (Map<String, Object> map : allData) {
			String write = "";
			String id = String.valueOf(map.get("emp_no"));
			String name = String.valueOf(map.get(EmpConstants.EMP_NAME));
			String email = String.valueOf(map.get(EmpConstants.EMP_ADD));
			write = id + " = " + name + " " + email + "\n";
			String dynamicPath = "C:\\Shoaib\\dev\\logs\\logger\\" + id + "_" + name + System.currentTimeMillis()
					+ ".txt";
			path = Files.write(Paths.get(dynamicPath), write.getBytes());
			pathList.add(path.toString());
		}

		return pathList;

	}

}
