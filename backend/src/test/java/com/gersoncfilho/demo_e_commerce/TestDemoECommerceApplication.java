package com.gersoncfilho.demo_e_commerce;

import org.springframework.boot.SpringApplication;

public class TestDemoECommerceApplication {

  public static void main(String[] args) {
    SpringApplication.from(DemoECommerceApplication::main)
        .with(TestcontainersConfiguration.class)
        .run(args);
  }
}
