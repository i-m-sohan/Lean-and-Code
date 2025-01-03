package com.CustomerManagementSystem.Customer;

public class Customer {
    private int customerID;
    private String companyName;
    private String contactName;
    private String country;

    public Customer() {}

    public Customer(int customerID, String companyName, String contactName, String country) {
        this.customerID = customerID;
        this.companyName = companyName;
        this.contactName = contactName;
        this.country = country;
    }
    
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    @Override
    public String toString() {
        return "CustomerID: " + customerID + ", CompanyName: " + companyName +
               ", ContactName: " + contactName + ", Country: " + country;
    }
}
