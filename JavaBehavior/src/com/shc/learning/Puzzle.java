package com.shc.learning;

import java.nio.charset.Charset;
import java.util.Stack;

public class Puzzle {

	/**
	 * 0  12   3  45   6    78      9  10   11
	 * [  []   [  []   [    []      ]   ]   ]
	 *  Result should be such pairs
	 *  0,11; 1,2; 3,10; 4,5; 6,9; 7,8; 
	 */
	public static void main(String[] args) {
		String puzzle = "[[][[][[]][[]]]]";
		Stack<Integer> repo = new Stack<Integer>(); 
		int i=0;
		try {
			for(Byte b : puzzle.getBytes(Charset.defaultCharset())) {
				char c = puzzle.charAt(i);
				if(c=='[') {
					repo.push(i);
				} else {
					int j = repo.pop();
					System.out.print(j+",");
					System.out.println(i);
				}
				i++;
			}
			if(!repo.isEmpty()) {
				System.out.println("incorrect data");
			}
		} catch (Exception e) {
			if(e instanceof java.lang.StringIndexOutOfBoundsException) {
				System.out.println("This is fine.");	
			}
		}
	}	
}
