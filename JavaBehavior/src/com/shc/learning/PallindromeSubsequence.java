package com.shc.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PallindromeSubsequence {

	private static final String sequenceUnderTest = "abacrhbdcaba";
	private static final String[] pallindromes = new String[10];
	
	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		performOperation();
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken is: "+(end-start));
	}
	
	
	private static void performOperation() {
		
		String sequence = "";
		char[] letters = sequenceUnderTest.toCharArray();
		int first = 0;
		int last = letters.length-1;

		char left = letters[first];
		char right = letters[last];
		
		for(;first <= last;) {
			if(left != right) {
				first = first + 1;
				left = letters[first];
			} else {
				sequence = sequence + left;
				first = first + 1;
				last = last - 1;
				left = letters[first];
				right = letters[last];
				continue;
			}
			left = letters[first];
			if(left != right) {
				last = last - 1;
				right = letters[last];
			} else {
				sequence = sequence + left;
				first = first + 1;
				last = last - 1;
				left = letters[first];
				right = letters[last];

				continue;
			}
			if(left != right) {
				continue;
			} else {
				sequence = sequence + left;
				first = first + 1;
				last = last - 1;
				left = letters[first];
				right = letters[last];

				continue;
			}
		}
		System.out.println(sequence);
	}
	
	private static void performOperation1() {
		
		StringBuffer sb = new StringBuffer();
		String[] letters = sequenceUnderTest.split("");
		int counter = 0;
		for(int i = 1; i < letters.length; i++) {
			String str = letters[i];
			if(sb.toString().contains(str)){
				sb.append(str);
				pallindromes[counter++] = sb.toString();
				sb = new StringBuffer(sb.toString());
			} else {
				sb.append(str);
			}
		}
		System.out.println(pallindromes);
	}
	
	private static void performOperation2() {
		String[] letters = sequenceUnderTest.split("");
		Map<String, List<Integer>> lettersWithIndices = new HashMap<String, List<Integer>>();
		for(int i = 1; i < letters.length; i++) {
			String str = letters[i];
			if(lettersWithIndices.containsKey(str)) {
				lettersWithIndices.get(str).add(i);
			} else {
				List<Integer> indices = new ArrayList<Integer>();
				indices.add(i);
				lettersWithIndices.put(str, indices);
			}
		}
		System.out.println(lettersWithIndices);
	}
}
