package com.gersoncfilho.demo_e_commerce.product.repository;

import com.gersoncfilho.demo_e_commerce.product.domain.ProductJpa;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductJpa, UUID> {}
