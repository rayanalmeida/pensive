package com.shc.learning;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Assignment1 {

	/**
	 * @param args
	 */
	private static final Log log = LogFactory.getLog(Assignment1.class);
	public static void main(String[] args) {

		Assignment1 obj = new Assignment1();
		obj.doSomething(new Integer(1),22);
		obj.doSomething(6, 8);
	}

	public void doSomething(int i) {
		System.out.println("Do something int" +i);
		log.info("log this");
	}
	
	public void doSomething(Integer i) {
		System.out.println("Do something Integer" +i);
	}
	
	public void doSomething(long l) {
		System.out.println("Do something long" +l);
	}
	
	public void doSomething(Long l) {
		System.out.println("Do something Long" +l);
	}

	public void doSomething(Object o) {
		System.out.println("Do something object" +o);
	}
	
	public void doSomething(String s) {
		System.out.println("Do something String" +s);
	}

	public void doSomething(int i, long l) {
		System.out.println("Do something int long");
	}
	public void doSomething(Integer i, int j) {
		System.out.println("Do something Integer long");
	}
	public void doSomething(Long i, Long l) {
		System.out.println("Do something LL long");
	}

	public void doSomething(long l, Integer i) {
		System.out.println("Do something long Integer");
	}

	public void doSomething(Long l, Integer i) {
		System.out.println("Do something Long Integer");
	}
	public void doSomething(Integer l, Integer i) {
		System.out.println("Do something I I");
	}
	public void doSomething(int l, int i) {
		System.out.println("Do something i i");
	}

	public void doSomething(long l, long i) {
		System.out.println("Do something l l");
	}

}
