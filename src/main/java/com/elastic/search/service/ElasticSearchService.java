package com.elastic.search.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.elastic.search.model.Product;
import com.elastic.search.util.ElasticSearchUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.function.Supplier;

import static co.elastic.clients.elasticsearch._types.TransformBuilders.search;

@Service
public class ElasticSearchService {

    private final ElasticsearchClient elasticsearchClient;

    public ElasticSearchService(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    public SearchResponse<Product> matchAllServices() throws IOException {
        Supplier<Query> supplier = ElasticSearchUtil.supplier();
        SearchResponse<Product> searchResponse = elasticsearchClient.search(s -> s.query(supplier.get()), Product.class);
        return searchResponse;
    }

    public SearchResponse<Product> matchAllProductServicesWithQuery() throws IOException {
        Supplier<Query> supplier = ElasticSearchUtil.supplier();
        SearchResponse<Product> searchResponse = elasticsearchClient.
                search(s -> s.index("perfect_products").query(supplier.get()), Product.class);
        return searchResponse;
    }

    public SearchResponse<Product> searchByField(String fieldName, String value) throws IOException {
        return elasticsearchClient.search(s -> s
                        .index("perfect_products")
                        .query(q -> q
                                .match(m -> m
                                        .field(fieldName)
                                        .query(value)
                                )
                        ),
                Product.class
        );
    }



}
