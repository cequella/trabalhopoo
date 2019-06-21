/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cequelldev.marketmanager;

import java.util.Map;

/**
 *
 * @author Usuario
 */
public class Sale extends ProductCollection {
    private Employee _saler;
    
    // Ctor
    Sale(Employee tSaler) {
        super(String.format("Venda da %s", tSaler.name()));
        _saler = tSaler;
    }
    
    // Getters
    public Employee saler() {
        return _saler;
    }
    public float total() {
        float priceSum = 0.0f;
        for(Map.Entry<Product, Integer> entry : _stock.entrySet()) {
            priceSum += entry.getValue() * entry.getKey().price();
        }
        return priceSum;
    }
    
    // Methods
    @Override
    public String toString() {
        String out = super.toString();
        out += String.format("\n\tTotal: R$ %.2f", total());
        return out;
    }
}
