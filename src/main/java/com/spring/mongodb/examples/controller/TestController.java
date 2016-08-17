package com.spring.mongodb.examples.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongodb.examples.domain.TestData;
import com.spring.mongodb.examples.repository.TestRepository;

@RestController
public class TestController {

    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Autowired
    private TestRepository testRepository;

    @RequestMapping("/create")
    public ResponseEntity<String> createUser() {
	TestData testData = new TestData();
	testData.setName("Vinu");
	testData.setReceiptId("123");
	testData.setUcc("456");
	
	TestData testData2 = new TestData();
	testData2.setName("Hello");
	testData2.setReceiptId("898");
	testData2.setUcc("333");
	mongoTemplate.save(testData);
	mongoTemplate.save(testData2);
	return new ResponseEntity<String>("Test", HttpStatus.OK);
    }

    @RequestMapping("/search")
    public ResponseEntity<String> searchUser() {
	List<String> receiptIds = new ArrayList<String>();
	receiptIds.add("123");
	receiptIds.add("12345");
	List<String> uccs = new ArrayList<String>();
	uccs.add("333");
	uccs.add("78");
	List<String> weeks = new ArrayList<String>();
	weeks.add("51");
	weeks.add("52");
	weeks.add("1");
	weeks.add("2");
	List<String> years = new ArrayList<String>();
	years.add("2015");
	years.add("2016");
	List<TestData> listOfTest = testRepository.findByReceiptIdInOrUccInAndFiscalWeekAndFiscalYear(receiptIds, uccs, "52", "2015");
	System.out.println("");
	return new ResponseEntity<String>("Data Retrieved: " + listOfTest.get(0).getName(), HttpStatus.OK);
    }

}
