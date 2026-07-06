package com.elastic.search.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.elastic.search.model.Product;
import com.elastic.search.service.ElasticSearchService;
import com.elastic.search.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final ElasticSearchService elasticSearchService;
    private final ElasticsearchClient elasticsearchClient;

    public ProductController(ProductService productService, ElasticSearchService elasticSearchService, ElasticsearchClient elasticsearchClient) {
        this.productService = productService;
        this.elasticSearchService = elasticSearchService;
        this.elasticsearchClient = elasticsearchClient;
    }

    @GetMapping("/findAll")
    public Iterable<Product> findAll() {
        return productService.getAllProducts();
    }

    @PostMapping("/create")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/matchAll")
    public List<Map> matchAll() throws IOException {
        SearchResponse<Map> searchResponse = elasticsearchClient.search(s -> s.query(q -> q.matchAll(m -> m)), Map.class);

        // Bazadan gələn real JSON açarlarını konsola yazdırırıq
        searchResponse.hits().hits().forEach(hit -> {
            System.out.println("BAZADAKI REAL DATA: " + hit.source());
        });

        return searchResponse.hits().hits().stream().map(h -> h.source()).collect(Collectors.toList());
    }



}