package com.spring.mongodb.examples.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Test {
    
    @Id
    private String name;
    
    private List<String> receiptIds;
    
    private List<String> uccs;
    
}
