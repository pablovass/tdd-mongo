package com.pablovass.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Category {
    @Id
    private Long id;
    private  String name;

}
