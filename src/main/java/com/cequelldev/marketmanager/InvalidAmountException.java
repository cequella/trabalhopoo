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
public class InvalidAmountException extends Exception {
    public InvalidAmountException(Product product) {
        super("Invalid amount of \'"+product.name()+"\' in the stock");
    }
}
