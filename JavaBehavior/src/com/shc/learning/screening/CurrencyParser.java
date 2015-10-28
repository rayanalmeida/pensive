package com.shc.learning.screening;

public class CurrencyParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String stringToParse = "-123,456.89";
		long start = System.currentTimeMillis();
		double amount = parseCurrency(stringToParse)*(stringToParse.indexOf("-")>=0 ? -1 : 1);
		long end = System.currentTimeMillis();

		System.out.println("The parsed value is "+ amount);
		System.out.println("Time taken is " + (end-start));
	}

	private static double parseCurrency(String numericStr) {
				
		//cleanup
		numericStr = numericStr.replaceAll("[^0-9.]","");
		System.out.println(numericStr);
		
		double value = 0.0;
		int length = numericStr.length();
		boolean postDecimal = false;
		String[] characters = numericStr.split("");
		int divider = 0;

		for(int i=1; i<length; i++) {
			if(characters[i].equals(".")) {
				postDecimal = true;
				divider=1;
				continue;
			} else {
				double digit = Double.valueOf(characters[i]);
				value = value*10 + digit;
				if(postDecimal)
					divider = divider*10;
			}
		}
		return value/divider;
	}
}
