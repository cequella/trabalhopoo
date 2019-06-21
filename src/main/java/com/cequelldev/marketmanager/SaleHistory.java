/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cequelldev.marketmanager;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class SaleHistory {
    private List<Sale> _saleList = new ArrayList<>();
    
    public void add(Sale sale) throws InvalidParameterException {
        if(sale == null) {
            throw new InvalidParameterException("Sale must not be null");
        }
        
        _saleList.add(sale);
    }
    
    public List<Sale> salesBySaler(Employee saler) {
        List<Sale> out = new ArrayList<>();
        
        for(final Sale current : _saleList) {
            if(current.saler().equals(saler)) {
                out.add(current);
            }
        }
        
        return out;
    }
    public float totalBySaler(Trainee saler) {
        float out = 0.0f;
        for(final Sale current : _saleList) {
            if(current.saler().equals(saler)) {
                out += current.total();
            }
        }
        
        return out;
    }
}
