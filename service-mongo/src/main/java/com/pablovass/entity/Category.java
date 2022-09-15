package com.pablovass.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
@Data @AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    @Id
    private Long id;
    private  String name;

}
