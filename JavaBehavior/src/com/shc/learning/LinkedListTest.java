package com.shc.learning;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {

		LinkedList<String> data = new LinkedList<String>();
		data.add("This");
		data.add("is");
		data.add("a");
		data.add("test");

		Iterator<String> itr = data.iterator();

		String head, next;


		while(itr.hasNext()) {			

			head = itr.next();
			
			if(null != head) {
				next = itr.next();
				//next set mode = head;
				head = next;				
			}
		}

	}

}
