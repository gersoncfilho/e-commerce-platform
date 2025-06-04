package com.gersoncfilho.demo_e_commerce;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
    info =
        @Info(
            title = "Swagger Demo E-Commerce API",
            version = "1.0.0",
            description = "Demo E-Commerce API with Swagger"))
public class DemoECommerceApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoECommerceApplication.class, args);
  }
}
