package com.elastic.search.repository.elastic;

import com.elastic.search.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticSearchRepository extends ElasticsearchRepository<Product, String> {

}
