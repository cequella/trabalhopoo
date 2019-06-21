/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cequelldev.marketmanager;

/**
 *
 * @author Usuario
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MarketExample example = new MarketExample();
        
        try {
            example.createStock();
            example.makeSells();
            example.makePayments();
        } catch (final Exception e) {
            System.out.println(e.toString());
        }
        
    }
    
}
