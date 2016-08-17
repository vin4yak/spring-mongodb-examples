package com.spring.mongodb.examples.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection="test")
@Getter
@Setter
public class TestData {
    
    @Id
    private String name;
    
    private String receiptId;
    
    private String ucc;
    
    private String fiscalWeek;
    
    private String fiscalYear;
    
}
