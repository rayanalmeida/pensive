package com.shc.learning.euler;

public class IntegerRightTriangles {

	/**
	 * @param args
	 */
	private static final int LONGEST_HYP_FOR_TRIANGLE_WITH_1000_PERIMETER = 499;
	private static final int[] hypotenuse = new int[LONGEST_HYP_FOR_TRIANGLE_WITH_1000_PERIMETER];
	
	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		performOperation();
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken "+(end - start));
	}
	
	private static void performOperation() {
		
	}

}
