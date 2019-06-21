/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cequelldev.marketmanager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class BudgetPayroll {
    private SaleHistory _history;
    
    // Ctor
    public BudgetPayroll(SaleHistory saleHistory) {
        _history = saleHistory;
    }
    
    public Map<Employee, Float> get(List<Employee> employeeList) {
        Map<Employee, Float> out = new HashMap<>();
        
        for(final Employee employee : employeeList) {
            List<Sale> sales = _history.salesBySaler(employee);
            out.put(employee, employee.salary(sales));
        }
        
        return out;
    }
}
