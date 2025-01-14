package com.namingConvention;

import com.namingConvention.services.*;

import com.namingConvention.input.InputValue;

import java.util.*;

public class Main {
	 public static void main(String[] args) {
		 InputValue inputHelper = new InputValue();
		 String countryCode = inputHelper.inputString("Enter Country Code : ");
		 AdjacentCountriesService service = new AdjacentCountriesService();
		 List<String> adjacentCountries = service.getAdjacentCountries(countryCode);
	     if(adjacentCountries!=null) {
	    	 System.out.println(adjacentCountries.toString());
	     }
	     else {
	    	 System.out.println("Data unavailable!");
	     }
	 }
}
