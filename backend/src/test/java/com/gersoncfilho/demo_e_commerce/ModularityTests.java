package com.gersoncfilho.demo_e_commerce;

import org.junit.Test;
import org.springframework.modulith.core.ApplicationModules;

public class ModularityTests {

    @Test
    public void testModularity() {
        ApplicationModules.of(DemoECommerceApplication.class).verify();
    }
}
