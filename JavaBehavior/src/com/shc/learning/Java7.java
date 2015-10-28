package com.shc.learning;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class Java7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		MirroredTypeException me = new MirroredTypeException(null);
//		MirroredTypesException mes = new MirroredTypesException(null);

		System.out.println("start");
		Map<String, String> table = new Hashtable<String, String>();
		//table.put(null, null);
		
		System.out.println("middle");
		Set<String> hSet = new HashSet<String>();
		hSet.add(null);
		
		System.out.println("end");
		
	}

}
