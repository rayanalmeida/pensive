package com.shc.learning.euler;

import java.math.BigInteger;

public class LargestPrimeFactor {

	private static final BigInteger number = new BigInteger("600851475143");
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		performOperation();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}

	private static void performOperation() {

		BigInteger maxDivider = getMaxDivider(number);

		while(maxDivider.compareTo(BigInteger.ONE) > 0) {

			if(hasRemainder(number, maxDivider)) {
				System.out.println("This is a factor");
				if(isPrime(maxDivider)) {
					System.out.println("... and it is prime");
					System.out.println(maxDivider);
					break;
				}
			}
			maxDivider = maxDivider.subtract(BigInteger.ONE);
		}
	}

	private static boolean isPrime(BigInteger quotient) {
		BigInteger maxDivider = getMaxDivider(quotient);

		BigInteger divider = new BigInteger("2");
		while(maxDivider.compareTo(divider) >= 0) {
			if(!hasRemainder(quotient, divider)) {
				System.out.println("not prime");
				return false;
			}
			divider = divider.add(BigInteger.ONE);
		}
		return true;
	}

	private static BigInteger getMaxDivider(BigInteger number){
		Double d = Math.sqrt(number.doubleValue());
		BigInteger maxDivider = new BigInteger(String.valueOf(d.intValue()));
		maxDivider = maxDivider.add(BigInteger.ONE);

		return maxDivider;
	}
	
	private static boolean  hasRemainder(BigInteger number, BigInteger divider) {
		BigInteger[] bi = number.divideAndRemainder(divider);
		BigInteger r = bi[1];

		return  r.compareTo(BigInteger.ZERO) != 0;
	}
}
