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
public class ManagerPayment implements IPaymenteCalc {
    @Override
    public float salaryCalc(List<Sale> saleList) {
        float total = 3000.0f;
        for(final Sale sale : saleList) {
            total += sale.total() *0.25; // 25% of commission
        }
        return total;
    }
}
