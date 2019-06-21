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
public class UnavailableProductException extends Exception {
    public UnavailableProductException(Product product) {
        super("\'"+product.name()+"\' not available at stock");
    }
}
