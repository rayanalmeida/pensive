package com.shc.learning;

public class OverloadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Helper.print(new Object());
		Helper.print("Hi");

	}
	
	public static class Helper {
		
		static void print(String s) {
			System.out.println("Printing string "+ s);
		}
		
		static void print(Object o) {
			System.out.println("printing object "+o);
		}
	}

}
