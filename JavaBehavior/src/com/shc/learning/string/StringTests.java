package com.shc.learning.string;

public class StringTests {
	
	public static void main(String[] args) {
		new StringTests().testEqauls();
	}
	
	private void testEqauls() {
		String x = "123";
		String y = "123";

		StringBuffer sb = new StringBuffer();
		sb.append("1").append("2").append("3");
		
		String z = sb.toString();
		
		System.out.println("x = "+x);
		System.out.println(x.hashCode());
		System.out.println("y = "+y);
		System.out.println(y.hashCode());
		System.out.println("z = "+z);
		System.out.println(z.hashCode());

		System.out.println("x==y = "+(x==y));
		System.out.println("x.equalsIgnoreCase(y) = "+x.equalsIgnoreCase(y));
		System.out.println("y==z = "+(y==z));
		System.out.println("y.equalsIgnoreCase(z) = "+y.equalsIgnoreCase(z));
		System.out.println("x==z = "+(x==z));
		System.out.println("x.equalsIgnoreCase(z) = "+x.equalsIgnoreCase(z));

	}
}
