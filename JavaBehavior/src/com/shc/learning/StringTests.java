package com.shc.learning;

public class StringTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(replace("this is won<salescheck>derful", "<salescheck>", "12345"));
//		System.out.println("this is won<salescheck>derful".replaceAll("<salescheck>", "12345"));
		//StringAndChar();
		subString();

	}
	
	public  static String replace(String source, String pattern, String replace){

		if (source!=null){

			final int len = pattern.length();
			StringBuffer sb = new StringBuffer();
			int found = -1;
			int start = 0;
			while( (found = source.indexOf(pattern, start) ) != -1) {
				sb.append(source.substring(start, found));
				sb.append(replace);
				start = found + len;
			}
			sb.append(source.substring(start));
			return sb.toString();
		}
		else return "";
	}
	
	public static void StringAndChar() {
		String str = "Y";
		char ch = 'Y';
		boolean flag = str.equals(ch);
		System.out.println(flag);
		
		flag = str.equals(String.valueOf(ch));
		System.out.println(flag);
		
		flag = str.equals(String.valueOf(null));
		System.out.println(flag);
		
		
	}
	
	public static void subString() {
		String source = "catcowcat";
		String pattern = "cow";
		
		int count = 0;
		
		while(true) {
			String src = source.replaceFirst(pattern, "");
			if(src == source)
				break;
			count++;
			source = src;
		}
		System.out.println(count);
		
	}

}
