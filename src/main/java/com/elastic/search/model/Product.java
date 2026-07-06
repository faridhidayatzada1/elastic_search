package com.elastic.search.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;


@Document(indexName = "perfect_products") // Tamamen taze bir indeks adı
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    @Id
    @JsonProperty("id")
    private String id;

    @Field(name = "name", type = FieldType.Text)
    @JsonProperty("name")
    private String name;

    @Field(name = "description", type = FieldType.Text)
    @JsonProperty("description")
    private String description;

    @Field(name = "quantity", type = FieldType.Integer)
    @JsonProperty("quantity")
    private Integer quantity;

    @Field(name = "price", type = FieldType.Double)
    @JsonProperty("price")
    private Double price;

    // 1. Boş Constructor
    public Product() {
    }

    // 2. Dolu Constructor
    public Product(String id, String name, String description, Integer quantity, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    // 3. Standart Getter ve Setter Metotları
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}
