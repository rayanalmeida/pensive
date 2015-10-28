package com.shc.learning.euler;

public class LongestCollatzSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxSeriesLength = 1;
		int length = 0;
		int numberWIthLongestChain = 1;
		long start = System.currentTimeMillis();

		for(int i = 1; i <=1000000; i++) {
			length = getSequenceLength(i);
			if(length > maxSeriesLength) {
				maxSeriesLength = length;
				numberWIthLongestChain = i;
			}
		}

		long end = System.currentTimeMillis();
		System.out.println(numberWIthLongestChain + " has longest series with length of "+maxSeriesLength);
		System.out.println("Time taken "+(end-start));
	}

	private static int getSequenceLength(int num){
		int seriesLength = 1;
		long number = num;
		//System.out.print(number);
		while(true) {
			//System.out.print(" ");
			number = number % 2 > 0 ? number*3 + 1 : number/2;
			//System.out.print(number);
			seriesLength++;
			if(number == 1L)
				break;			
		}
		//System.out.println(" Length of series "+seriesLength);
		return seriesLength;
	}
}
