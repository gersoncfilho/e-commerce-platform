package com.gersoncfilho.demo_e_commerce.product.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Entity(name = "product")
@Table(name = "product")
@Data
public class ProductJpa {
  @Id private UUID id;
  private String name;
  private String description;
  private BigDecimal price;
  private Integer stock;

  private ProductJpa(Builder builder) {
    this.id = UUID.randomUUID();
    this.name = builder.name;
    this.description = builder.description;
    this.price = builder.price;
    this.stock = builder.stock;
  }

  public ProductJpa() {}

  public static class Builder {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Builder price(BigDecimal price) {
      this.price = price;
      return this;
    }

    public Builder stock(Integer stock) {
      this.stock = stock;
      return this;
    }

    public ProductJpa build() {
      return new ProductJpa(this);
    }
  }
}
