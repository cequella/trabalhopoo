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
public class Saler extends Employee {
    
    public Saler(String name) {
        super(name, new CommonPayment());
    }
    
}
