package com.CustomerManagementSystem.CustomerDataTransformer;

import java.util.List;

import com.CustomerManagementSystem.Customer.Customer;

public class CustomerDataTransformer {

	public String exportToCSV(List<Customer> data) {
        StringBuilder sb = new StringBuilder();
        sb.append("CustomerID")
        .append(",")
        .append("Company")
        .append(",")
        .append("Contact")
        .append(",")
        .append("Country")
        .append("\n");
        for (Customer item : data) {
            sb.append(item.getCustomerID())
              .append(",")
              .append(item.getCompanyName())
              .append(",")
              .append(item.getContactName())
              .append(",")
              .append(item.getCountry())
              .append("\n"); // Add a new line after each entry
        }
        
        return sb.toString();
    }
}
