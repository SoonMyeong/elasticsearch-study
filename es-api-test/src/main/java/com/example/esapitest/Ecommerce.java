package com.example.esapitest;

import lombok.Value;
import org.springframework.data.elasticsearch.annotations.Document;

@Value
@Document(indexName = "kibana_sample_data_ecommerce")
public class Ecommerce {
    String category;
    String customerFirstName;
}
