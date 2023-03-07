package com.example.esapitest;

import lombok.RequiredArgsConstructor;;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final ElasticsearchOperations elasticsearchOperations;

    @GetMapping("/test")
    public String test() {
        SearchHit[] commerces = elasticsearchOperations.query(query(), response -> response.getHits().getHits());
        return "";
    }

    private NativeSearchQuery query() {
        TermQueryBuilder queryBuilder = QueryBuilders
                .termQuery("category.keyword","Men's Clothing");

        return new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withPageable(PageRequest.of(0,100))
                .build();
    }
}
