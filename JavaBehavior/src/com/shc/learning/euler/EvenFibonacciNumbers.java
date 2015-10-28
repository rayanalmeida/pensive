package com.shc.learning.euler;

public class EvenFibonacciNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long currentTerm = 1L;
		long nextTerm = 1L;
		long sum = 1L;
		long result = 0L;
		
		while(currentTerm <= 4000000L) {
			nextTerm = currentTerm + sum;			
			currentTerm = sum;
			
			System.out.println(currentTerm);
			
			if(currentTerm % 2 == 0) {
				result = result + currentTerm;
			}
			sum = nextTerm;			
		}
		System.out.println("Result is "+result);
	}
}
