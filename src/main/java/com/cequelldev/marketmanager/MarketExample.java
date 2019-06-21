/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cequelldev.marketmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class MarketExample {
    ProductCollection stock = new Stock();
    List<Employee> employeeList = new ArrayList<>();
    SaleHistory history = new SaleHistory();
    
    public MarketExample() {
        employeeList.add(new Manager("Paulo"));
        employeeList.add(new Saler("Gloria"));
        employeeList.add(new Saler("Higor"));
        employeeList.add(new Trainee("Selena"));
    }
    
    public void createStock() {
        stock.add(new Product(1, "Xablau", 10.0f), 20);
        stock.add(new Product(2, "Xibiu", 10.0f), 30);
        stock.add(new Product(3, "Bufu", 10.0f), 15);
        stock.add(new Product(4, "Blablau", 10.0f), 25);
        stock.add(new Product(5, "Curupira", 10.0f), 20);
        
        System.out.println(stock);
    }
    
    public void makeSells() {
        final List<Product> availableProducts = stock.availableProducts(); 
        
        Sale salePaulo1 = new Sale(employeeList.get(0));
        salePaulo1.add(availableProducts.get(0), 5);
        salePaulo1.add(availableProducts.get(1), 3);
        salePaulo1.add(availableProducts.get(2), 1);
        
        Sale saleGloria1 = new Sale(employeeList.get(1));
        saleGloria1.add(availableProducts.get(0), 2);
        saleGloria1.add(availableProducts.get(1), 2);
        saleGloria1.add(availableProducts.get(2), 4);
        saleGloria1.add(availableProducts.get(3), 4);
        
        Sale saleGloria2 = new Sale(employeeList.get(1));
        saleGloria1.add(availableProducts.get(1), 4);
        saleGloria1.add(availableProducts.get(4), 5);
        saleGloria1.add(availableProducts.get(3), 8);
        saleGloria1.add(availableProducts.get(2), 10);
        
        Sale saleSelena1 = new Sale(employeeList.get(3));
        saleSelena1.add(availableProducts.get(0), 1);
        saleSelena1.add(availableProducts.get(1), 4);
        saleSelena1.add(availableProducts.get(2), 3);
        
        history.add(salePaulo1);
        history.add(saleGloria1);
        history.add(saleGloria2);
        history.add(saleSelena1);
    }
    
    public void makePayments() {
        BudgetPayroll payroll = new BudgetPayroll(history);
        
        Map<Employee, Float> salary = payroll.get(employeeList);
        
        System.out.println("Payments: ");
        for(Map.Entry<Employee, Float> entry : salary.entrySet()) {
            System.out.println(String.format(
                    "\t%s will receive R$ %.2f",
                    entry.getKey().toString(),
                    entry.getValue()
            ));
        }
    }
}
