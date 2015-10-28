package com.shc.learning;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class CharacterEncodings {

	/**
	 * @param args
	 */
	
	private static final String[] encodings = new String[] {"Cp1252", "UTF-8", "UTF-16BE"};
	public static void main(String[] args) throws UnsupportedEncodingException {

		String poundSignInUnicode = "\u00A3";
		System.out.println(Charset.defaultCharset());
		System.out.println(System.getProperty("file.encoding"));
		
		System.out.println("Default encoding "+poundSignInUnicode);		
		
		for(String encoding : encodings) {
			System.out.format("%10s%3s ", encoding, poundSignInUnicode);
			byte[] encoded = poundSignInUnicode.getBytes(encoding);
			for(byte b : encoded) {
				System.out.format("%02x ", b);
			}
			System.out.println();
		}		
	}
}
