package com.shc.learning;

public class Assignment2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		H1 obj = new H2();
		obj.doSomething();
		System.out.println(obj.x);

	}
}
class H1 {
	int x = 10;

	void doSomething() {
		doSomething1();
		doSomething2();
	}

	void doSomething1() {
		System.out.println("H1.doSomething1");
	}
	void doSomething2() {
		System.out.println("H1.doSomething2");
	}
}

class H2 extends H1 {
	int x = 20;

	void doSomething() {
		System.out.println("died");
	}
	void doSomething1() {
		System.out.println("H2.doSomething1");
	}
	void doSomething2() {
		System.out.println("H2.doSomething2");
	}
}
