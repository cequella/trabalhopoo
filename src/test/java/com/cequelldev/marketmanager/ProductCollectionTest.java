/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cequelldev.marketmanager;

import com.cequelldev.marketmanager.ProductCollection;
import com.cequelldev.marketmanager.UnavailableProductException;
import com.cequelldev.marketmanager.Product;
import com.cequelldev.marketmanager.InvalidAmountException;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Usuario
 */
public class ProductCollectionTest {

    @Test
    public void testAddNullProduct() {
        ProductCollection stock = new ProductCollection("Generic");
        
        assertThrows(InvalidParameterException.class, () -> {
            stock.add(null, 1);
        });
    }
    
    /*@Test
    public void testAddRepeatedProduct() {
        Stock stock = new Stock();
        
        stock.add(new Product(1, "Product", 10.0f), 10);
        stock.add(new Product(1, "Product", 10.0f), 10);
        
        assertEquals(20, stock.availableAmount(new Product(1, "Product", 10.0f)));
    }*/
    
    @Test
    public void testAddZeroAmountProduct() {
        ProductCollection stock = new ProductCollection("Generic");
        
        assertThrows(InvalidParameterException.class, () -> {
            stock.add(new Product(1, "ProductA", 1.0f), 0);
        });
    }
    
    @Test
    public void testAddNegativeAmountProduct() {
        ProductCollection stock = new ProductCollection("Generic");
        
        assertThrows(InvalidParameterException.class, () -> {
            stock.add(new Product(1, "ProductA", 1.0f), -1);
        });
    }
    
    @Test
    public void testRemoveNullProduct() {
        ProductCollection stock = new ProductCollection("Generic");
        
        Product productA = new Product(1, "ProductA", 1.0f);
        
        stock.add(productA, 10);
        assertThrows(InvalidParameterException.class, () -> {
            stock.remove(null, 10);
        });
    }
    
    @Test
    public void testRemoveUnavailableProduct() {
        ProductCollection stock = new ProductCollection("Generic");
        
        Product productA = new Product(1, "ProductA", 1.0f);
        Product productB = new Product(2, "ProductB", 1.0f);
        
        stock.add(productA, 10);
        assertThrows(UnavailableProductException.class, () -> {
            stock.remove(productB, 10);
        });
    }
    
    @Test
    public void testRemoveUnavailableAmountOfProduct() {
        ProductCollection stock = new ProductCollection("Generic");
        
        Product product = new Product(1, "Product", 1.0f);
        stock.add(product, 10);
        
        assertThrows(InvalidAmountException.class, () -> {
            stock.remove(product, 20);
        });
    }
    
    @Test
    public void testRemoveZeroAmountOfProduct() {
        ProductCollection stock = new ProductCollection("Generic");
        
        Product product = new Product(1, "Product", 1.0f);
        stock.add(product, 10);
        
        assertThrows(InvalidParameterException.class, () -> {
            stock.remove(product, 0);
        });
    }
    
    @Test
    public void testRemoveNegativeAmountOfProduct() {
        ProductCollection stock = new ProductCollection("Generic");
        
        Product product = new Product(1, "Product", 1.0f);
        stock.add(product, 10);
        
        assertThrows(InvalidParameterException.class, () -> {
            stock.remove(product, -1);
        });
    }
    
    @Test
    public void testRemoveValidAmountOfProduct() throws Exception {
        ProductCollection stock = new ProductCollection("Generic");
        
        Product product = new Product(1, "Product", 1.0f);
        stock.add(product, 10);
        stock.remove(product, 5);
        
        assertEquals(5, stock.availableAmount(product));
    }
    
    @Test
    public void testCheckNullProductAvailability() {
        ProductCollection stock = new ProductCollection("Generic");
        
        Product product = new Product(1, "Product", 1.0f);
        stock.add(product, 10);
        
        assertThrows(InvalidParameterException.class, () -> {
            stock.availableAmount(null);
        });
    }
    
    @Test
    public void testCheckValidProductAvailability() {
        ProductCollection stock = new ProductCollection("Generic");
        
        Product product = new Product(1, "Product", 1.0f);
        stock.add(product, 10);
        
        assertEquals(10.0f, stock.availableAmount(product));
    }
    
    @Test
    public void testCheckInvalidProductAvailability() {
        ProductCollection stock = new ProductCollection("Generic");
        
        Product productA = new Product(1, "ProductA", 1.0f);
        Product productB = new Product(2, "ProductB", 1.0f);
        stock.add(productA, 10);
        
        assertEquals(0.0f, stock.availableAmount(productB));
    }
    
}
