package com.nttdata.bootcamp.customertype.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customertype")
public class Customertype {
    @Id
    private String id= UUID.randomUUID().toString();
    private String type;
    private Boolean status;
    private String description;
}
