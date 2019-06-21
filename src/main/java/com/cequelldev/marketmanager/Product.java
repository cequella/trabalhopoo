/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cequelldev.marketmanager;

import java.security.InvalidParameterException;

/**
 *
 * @author Usuario
 */
public final class Product {
    private int _id; // codebar equivalent
    private float _price;
    private String _name;
    
    // Ctor
    public Product(int tId, String tName, float tPrice) throws InvalidParameterException {
        if(tName == null) {
            throw new InvalidParameterException("Name must no be null");
        }
        if(tPrice <= 0.0) {
            throw new InvalidParameterException("Price cannot be zero or negative");
        }
        
        _id = tId;
        _name = tName;
        _price = tPrice;
    }
    
    // Getters
    public int id() {
        return _id;
    }
    public float price() {
        return _price;
    }
    public String name() {
        return _name;
    }
    
    // Methods
    @Override
    public String toString() {
        return name() + ": R$ " + String.format("%.2f", price());
    }
    
    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || !(o instanceof Product)) {
            return false;
        }
        
        Product that = (Product) o;
        return that.id() == id() && that.name().equals(name());
    }
}
