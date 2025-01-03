package com.CustomerManagementSystem.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.CustomerManagementSystem.connectionManager.*;

public class CustomerSelector {

	public List<Customer> getCustomersByCountry(String country){
		List<Customer> searchedCustomers = new ArrayList<Customer>();
		String query = "SELECT * FROM customers WHERE country = ?";
		
		try(Connection connection = ConnectionManager.getConnection(); PreparedStatement searchQueryRunner = connection.prepareStatement(query)) {
			searchQueryRunner.setString(1, country);
			try (ResultSet foundPlans = searchQueryRunner.executeQuery()) {
                while (foundPlans.next()) {
                	searchedCustomers.add(
                			new Customer(foundPlans.getInt("customerID"),foundPlans.getString("Company"),foundPlans.getString("Contact"),foundPlans.getString("Country"))
                			);
                }
            }
			return searchedCustomers;
		}catch(SQLException e) {
			System.out.println("Issue occured while searching!");
		}
		catch(NullPointerException e) {
			System.out.println("Problem Occured in the query!");
		}
		return null;
	}
	
	public List<Customer> getCustomersByCompany(String company){
		List<Customer> searchedCustomers = new ArrayList<Customer>();
		String query = "SELECT * FROM customers WHERE company = ?";
		
		try(Connection connection = ConnectionManager.getConnection(); PreparedStatement searchQueryRunner = connection.prepareStatement(query)) {
			searchQueryRunner.setString(1, company);
			try (ResultSet foundPlans = searchQueryRunner.executeQuery()) {
                while (foundPlans.next()) {
                	searchedCustomers.add(
                			new Customer(foundPlans.getInt("customerID"),foundPlans.getString("Company"),foundPlans.getString("Contact"),foundPlans.getString("Country"))
                			);
                }
            }
			return searchedCustomers;
		}catch(SQLException e) {
			System.out.println("Issue occured while searching!");
		}
		catch(NullPointerException e) {
			System.out.println("Problem Occured in the query!");
		}
		return null;
	}
	
	public List<Customer> getCustomersByContact(String contact){
		List<Customer> searchedCustomers = new ArrayList<Customer>();
		String query = "SELECT * FROM customers WHERE company = ?";
		
		try(Connection connection = ConnectionManager.getConnection(); PreparedStatement searchQueryRunner = connection.prepareStatement(query)) {
			searchQueryRunner.setString(1, contact);
			try (ResultSet foundPlans = searchQueryRunner.executeQuery()) {
                while (foundPlans.next()) {
                	searchedCustomers.add(
                			new Customer(foundPlans.getInt("customerID"),foundPlans.getString("Company"),foundPlans.getString("Contact"),foundPlans.getString("Country"))
                			);
                }
            }
			return searchedCustomers;
		}catch(SQLException e) {
			System.out.println("Issue occured while searching!");
		}
		catch(NullPointerException e) {
			System.out.println("Problem Occured in the query!");
		}
		return null;
	}
}
