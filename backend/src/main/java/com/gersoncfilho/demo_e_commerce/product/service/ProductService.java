package com.gersoncfilho.demo_e_commerce.product.service;

import com.gersoncfilho.demo_e_commerce.product.domain.ProductJpa;
import com.gersoncfilho.demo_e_commerce.product.exception.ProductPersistenceException;
import com.gersoncfilho.demo_e_commerce.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

  private final ProductRepository productRepository;

  @Transactional
  public ProductJpa save(ProductJpa product) {
    try {
      ProductJpa saved = productRepository.save(product);
      log.info("Product successfully saved: ID={}", saved.getId());
      return saved;
    } catch (Exception e) {
      log.error("Error saving product: {}", product, e);
      throw new ProductPersistenceException("Fail to save product to database.", e);
    }
  }

  @Transactional(readOnly = true)
  public ProductJpa findById(UUID id) {
    return productRepository
            .findById(id)
            .orElseThrow(() -> {
              log.warn("Product id {} not found", id);
              return new IllegalArgumentException("Product not found ID: " + id);
            });
  }

  @Transactional(readOnly = true)
  public List<ProductJpa> findAll() {
    return productRepository.findAll();
  }

  @Transactional
  public void deleteById(UUID id) {
    try {
      productRepository.deleteById(id);
      log.info("Product successfully deleted on: ID={}", id);
    } catch (Exception e) {
      log.error("Error on delete product ID: {}", id, e);
      throw new ProductPersistenceException("Fail to delete product.", e);
    }
  }
}