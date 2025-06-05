package com.gersoncfilho.demo_e_commerce.product.api;

import static org.springframework.http.HttpStatus.*;

import com.gersoncfilho.demo_e_commerce.api.ProductsApi;
import com.gersoncfilho.demo_e_commerce.model.Product;
import com.gersoncfilho.demo_e_commerce.product.domain.ProductJpa;
import com.gersoncfilho.demo_e_commerce.product.mapper.ProductMapper;
import com.gersoncfilho.demo_e_commerce.product.service.ProductService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "api/v1", produces = "application/json")
public class ProductsApiImpl implements ProductsApi {

  private final ProductService service;
  private final ProductMapper mapper;

  @PostMapping("/products")
  @Override
  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    ProductJpa toSave = mapper.toProductJpa(product);
    ProductJpa saved = service.save(toSave);
    return ResponseEntity.status(CREATED).body(mapper.toProduct(saved));
  }

  @GetMapping("products/{id}")
  @Override
  public ResponseEntity<Product> getProductById(@PathVariable UUID id) {
    try {
      ProductJpa found = service.findById(id);
      return ResponseEntity.ok(mapper.toProduct(found));
    } catch (IllegalArgumentException e) {
      throw new ResponseStatusException(NOT_FOUND, "Product not found with id: " + id);
    }
  }

  @PutMapping("products/{id}")
  @Override
  public ResponseEntity<Product> updateProduct(@PathVariable UUID id, @RequestBody Product product) {
    try {
      ProductJpa existing = service.findById(id);
      ProductJpa updated = mapper.toProductJpa(product);
      updated.setId(id);
      ProductJpa saved = service.save(updated);
      return ResponseEntity.ok(mapper.toProduct(saved));
    } catch (IllegalArgumentException e) {
      throw new ResponseStatusException(NOT_FOUND, "Product not found with id: " + id);
    }
  }

  @DeleteMapping("/products/{id}")
  @Override
  public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
    try {
      service.deleteById(id);
      return ResponseEntity.noContent().build();
    } catch (EmptyResultDataAccessException e) {
      throw new ResponseStatusException(NOT_FOUND, "Product not found with id: " + id);
    }
  }

  @GetMapping("/products")
  @Override
  public ResponseEntity<List<Product>> getAllProducts() {
    List<ProductJpa> all = service.findAll();
    List<Product> response = all.stream().map(mapper::toProduct).collect(Collectors.toList());
    return ResponseEntity.ok(response);
  }
}
