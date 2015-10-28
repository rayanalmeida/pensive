package com.shc.learning.euler;


public class ConsecutivePrimeSum {

	private static int[] primesUnderMillion = new int[550];
	private static int countOfPrimeNumbers = 0;
	
	public static void main(String[] args) {

		fetchAllPrimes();
		startMining();		
		System.out.println("Total # of prime numbers "+countOfPrimeNumbers);
	}
	
	private static void startMining() {
		
		int seriesLength = 1;
		int finalSeriesLength = 1;
		int derivedNum = 0;
		int derivedPrime = 0;
		for(int i = 3; (i < countOfPrimeNumbers && derivedNum <= 1000000); i++) {
			derivedNum = derivedNum + primesUnderMillion[i];
			if(isPrime(derivedNum)) {
				derivedPrime = derivedNum;
				finalSeriesLength = seriesLength;
			}
			seriesLength++;
		}		
		System.out.println("The prime "+derivedPrime+" can be written as sum of "+finalSeriesLength+" consecutive primes");
	}
	
	private static void fetchAllPrimes() {
		
		primesUnderMillion[0] = 2;
		int index = 1;
		
		for(int i=3; i <= 4000; i++) {
			if(isPrime(i)) {
				primesUnderMillion[index++] = i;
				countOfPrimeNumbers++;
			}
		}
	}
	
	private static boolean isPrime(int number) {
		Double limit = Math.sqrt(Double.valueOf(number));
		limit = limit + 1;
		for(int j=2; j <= limit.intValue(); j++) {
			if(number % j == 0) {
				return number == 2 ? true : false;
			}
		}
		return true;
	}
}
