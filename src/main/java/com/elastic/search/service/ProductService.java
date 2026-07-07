package com.elastic.search.service; // Paket isminizi kontrol edin

import com.elastic.search.model.Product;
import com.elastic.search.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

//    public Product updateProduct(Product product, int id){
//        Product prd = productRepository.findById(String.valueOf(id)).get();
//        prd.setPrice(product.getPrice());
//        return prd;
//    }


}
