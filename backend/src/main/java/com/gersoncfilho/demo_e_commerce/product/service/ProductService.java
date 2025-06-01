package com.gersoncfilho.demo_e_commerce.product.service;

import com.gersoncfilho.demo_e_commerce.product.domain.ProductJpa;
import com.gersoncfilho.demo_e_commerce.product.repository.ProductRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public ProductJpa save(ProductJpa product) {
    return productRepository.save(product);
  }

  public ProductJpa findById(UUID id) {
    return productRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));
  }

  public List<ProductJpa> findAll() {
    return productRepository.findAll();
  }

  public void deleteById(UUID id) {
    productRepository.deleteById(id);
  }
}
