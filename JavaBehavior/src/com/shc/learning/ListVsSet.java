package com.shc.learning;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ListVsSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListVsSet obj = new ListVsSet();
		obj.process();

	}
	
	private void process() {
		List<String> list = new LinkedList<String>();
		list.add("RAYAN");
		list.add("RAYAN");
		list.add("RAYAN");
		System.out.println(list.size());
		
		Set<String> set = new HashSet<String>();
		set.add("VIRA");
		set.add("VIRA");
		set.add("VIRA");
		set.add("VIRA");
		System.out.println(set.size());
	}

}
