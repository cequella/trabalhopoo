/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cequelldev.marketmanager;

import com.cequelldev.marketmanager.Product;
import java.security.InvalidParameterException;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Usuario
 */
public class ProductTest {
    
    @org.junit.jupiter.api.Test
    public void testCheckEquals() {
        Product productA = new Product(1, "Product", 10.0f);
        Product productB = new Product(1, "Product", 30.0f);
        
        assertEquals(productA, productB);
    }
    
    @org.junit.jupiter.api.Test
    public void testNullName() {
        assertThrows(InvalidParameterException.class, ()->{
            new Product(1, null, 10.0f);
        });
    }
    
    @org.junit.jupiter.api.Test
    public void testConstructorWithPriceZero() {
        assertThrows(InvalidParameterException.class, ()->{
            new Product(1, "", 0.0f);
        });
    }
    
    @org.junit.jupiter.api.Test
    public void testConstructorWithNegativePrice() {
        assertThrows(InvalidParameterException.class, ()->{
            new Product(1, "", -10.0f);
        });
    }
    
}
