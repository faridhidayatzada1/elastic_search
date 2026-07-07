package com.elastic.search.util;

import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.text_structure.test_grok_pattern.MatchedField;
import lombok.val;

import java.util.function.Supplier;

public class ElasticSearchUtil {

    public static Supplier<Query> supplier() {
        return () -> Query.of(q -> q.matchAll(m -> m));
    }


    public static MatchAllQuery matchAllQuery() {
        MatchAllQuery matchAllQuery = new MatchAllQuery.Builder().build();
        return matchAllQuery;
    }

    public static MatchQuery matchedFieldName(String fieldName){
        return new MatchQuery.Builder().field("name").query(fieldName).build();
    }
}
