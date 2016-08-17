package com.spring.mongodb.examples.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongodb.examples.domain.TestData;

public interface TestRepository extends MongoRepository<TestData, String> {
    List<TestData> findByReceiptIdInOrUccInAndFiscalWeekAndFiscalYear(List<String> receiptIds, List<String> uccs, String week, String year);
}
