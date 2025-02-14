package com.namingConvention.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValue {
	Scanner inputs ;
	public InputValue() {
		inputs = new Scanner(System.in);
	}
	public Integer inputInt(String msg) {
		System.out.println(msg);
		int value=-1;
		try {
			value = inputs.nextInt();
			inputs.nextLine();
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid input : Expected integer value as input");
			inputs.nextLine();
			return null;
		}
		return value;
	}
	public Integer inputInt() {
		int value=-1;
		try {
			value = inputs.nextInt();
			inputs.nextLine();
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid input : Expected integer value as input");
			inputs.nextLine();
			return null;
		}
		return value;
	}
	public String inputString(String msg) {
		System.out.println(msg);
		String value = "";
		try {
			value = inputs.next();
			inputs.nextLine();
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid input : Expected String value as input");
			inputs.nextLine();
			return null;
		}
		return value;
	}
	public Double inputDouble(String msg) {
		System.out.println(msg);
		double value=-1.0;
		try {
			value = inputs.nextDouble();
			inputs.nextLine();
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid input : Expected Double value as input");
			inputs.nextLine();
			return null;
		}
		return value;
	}
	public Long inputLong(Long msg) {
		System.out.println(msg);
		long value=-1;
		try {
			value = inputs.nextLong();
			inputs.nextLine();
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid input : Expected Long value as input");
			inputs.nextLine();
			return null;
		}
		return value;
	}
	public String inputLine(String msg) {
		System.out.println(msg);
		String value="";
		try {
			value = inputs.nextLine();
		}
		catch(InputMismatchException e) {
			inputs.nextLine();
			return null;
		}
		return value;
	}
	public int inputIntValue(String msg) {
		System.out.println(msg);
		int value=-1;
		try {
			value = inputs.nextInt();
		}
		catch(InputMismatchException e) {
			inputs.nextLine();
		}
		return value;
	}
	
}
