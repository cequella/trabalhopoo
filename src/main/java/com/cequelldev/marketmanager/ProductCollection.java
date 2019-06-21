/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cequelldev.marketmanager;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class ProductCollection {
    private String _name;
    protected Map<Product, Integer> _stock = new HashMap<>();
    
    public ProductCollection(String tName) {
        _name = tName;
    }
    
    @Override
    public String toString() {
        String out = String.format("%s: ", _name);
        
        if(_stock.isEmpty()) {
            out.concat("Vazio");
        } else {
            for(Map.Entry<Product, Integer> entry : _stock.entrySet()) {
                out += String.format(
                        "\n\t%d unidades de %s", 
                        entry.getValue(), 
                        entry.getKey().toString());
            }
        }
        
        return out;
    }
    
    public int availableAmount(Product product) throws InvalidParameterException {
        if(product == null) {
            throw new InvalidParameterException("Product cannot be null");
        }
        
        if(_stock.containsKey(product)) {
            return _stock.get(product);
        } else {
            return 0;
        }
    }
    
    public void add(Product product, int amount) throws InvalidParameterException {
        if(product == null) {
            throw new InvalidParameterException("Null product");
        }
        if(amount <= 0.0) {
            throw new InvalidParameterException("Amount cannot be zero or negative");
        }

        final int newAmount = amount + availableAmount(product);
        _stock.put(product, newAmount);
    }
    
    public void remove(Product product, int amount) throws Exception {
        if(product == null) {
            throw new InvalidParameterException("Product must not be null");
        }
        if(!_stock.containsKey(product)) {
            throw new UnavailableProductException(product);
        }
        if(amount <= 0.0) {
            throw new InvalidParameterException("Cannot remove non-positive amount");
        }
        
        final int newAmount = availableAmount(product) - amount;

        if(newAmount < 0.0) {
            throw new InvalidAmountException(product);
        } else if(newAmount == 0.0) {
            _stock.remove(product);
        } else {
            _stock.replace(product, newAmount);
        }
    }
    
    public List<Product> availableProducts() {
        if(_stock.isEmpty()) {
            return new ArrayList<Product>();
        }
        
        return new ArrayList<Product>(_stock.keySet());
    }
    
    public Product findById(int id) {
        for(final Product product : _stock.keySet()) {
            if(product.id() == id) {
                return product;
            }
        }
        return null;
    }
}
