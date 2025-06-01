package com.gersoncfilho.demo_e_commerce.product.mapper;

import com.gersoncfilho.demo_e_commerce.model.Product;
import com.gersoncfilho.demo_e_commerce.product.domain.ProductJpa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
  ProductJpa toProductJpa(Product product);

  Product toProduct(ProductJpa productJpa);
}
