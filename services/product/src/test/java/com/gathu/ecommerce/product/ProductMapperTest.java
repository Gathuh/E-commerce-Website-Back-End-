package com.gathu.ecommerce.product;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductMapperTest {
    @AfterAll
    static void afterAll() {
        System.out.printf("Inside after all method");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.printf("Inside before all method");
    }

    @BeforeEach
    void setUp() {
        System.out.printf("Before Each panel");
    }

    @Test
    public void testMethod1(){
        System.out.println("My first Test");
    }
    @Test
    public void testMethod2(){
        System.out.println("My Second Test");
    }

}