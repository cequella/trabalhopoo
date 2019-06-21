/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cequelldev.marketmanager;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Employee {
    static int MAT = 0;
    
    private int _mat;
    private String _name;
    private IPaymenteStrategy _payment;
    
    // Ctor
    public Employee(String name, IPaymenteStrategy tPayment) {
        _mat = MAT+1;
        _name = name;
        _payment = tPayment;
        
        MAT++; // MAT update
    }
    
    // Getters
    public int mat() {
        return _mat;
    }
    public String name() {
        return _name;
    }
    public float salary(List<Sale> saleList) {
        return _payment.salaryCalc(saleList);
    }
    
    // Methods
    @Override
    public String toString() {
        return String.format("%s (Mat: %d)", name(), mat());
    }
}
