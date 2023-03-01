package com.example.demo.service;

import com.example.demo.domain.Ecommerce;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ReactiveElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class SearchTestService {
    private final ReactiveElasticsearchOperations elasticsearchOperations;

    public Flux<Ecommerce> search() {
        return elasticsearchOperations.search(query(), Ecommerce.class)
                .map(SearchHit::getContent);
    }

    private Query query() {
        return NativeQuery.builder()
                .withQuery(q -> q
                        .term(m -> m.field("category.keyword").value("Men's Clothing")))
                .build();
    }

}
