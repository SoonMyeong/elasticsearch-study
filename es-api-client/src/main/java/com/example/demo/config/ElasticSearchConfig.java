package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchClients;
import org.springframework.data.elasticsearch.client.elc.ReactiveElasticsearchConfiguration;

@Configuration
public class ElasticSearchConfig extends ReactiveElasticsearchConfiguration {

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedToLocalhost()
                .withClientConfigurer(ElasticsearchClients.ElasticsearchHttpClientConfigurationCallback
                        .from(httpAsyncClientBuilder -> {
                            // configure the HttpAsyncClient
                            return httpAsyncClientBuilder;}))
                .build();
    }
}
