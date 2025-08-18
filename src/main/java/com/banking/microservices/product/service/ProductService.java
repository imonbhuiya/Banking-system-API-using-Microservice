package com.banking.microservices.product.service;

import com.banking.microservices.product.dto.ProductRequest;
import com.banking.microservices.product.dto.ProductResponse;
import com.banking.microservices.product.model.Product;
import com.banking.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
   // public List<ProductResponse> getAllProduct;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product created");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
}

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product ->new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()) )
                .toList();

    }
}

