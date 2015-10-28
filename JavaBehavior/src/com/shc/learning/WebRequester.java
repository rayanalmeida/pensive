package com.shc.learning;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class WebRequester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		WebRequester obj = new WebRequester();
		obj.makeWebCall();
	}
	
	private void makeWebCall() {
		URL url = null;
		HttpURLConnection conn = null;
		InputStreamReader in = null;
		try {
			url = new URL("http://google.com");
			conn = (HttpURLConnection) url.openConnection();
			
			displayMetadata(conn); 
//			conn.connect();
//			conn.setDoInput(true);
			in = new InputStreamReader(conn.getInputStream(), Charset.forName("UTF-8"));
			
			char[] data = new char[1024];
			StringBuilder sb = new StringBuilder();
			
			while(true) {
				int count = in.read(data);
				if(count <= 0) 
					break;
				sb.append(data, 0, count);
			}
			System.out.println(sb.toString());
			displayMetadata(conn);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(in != null) 
					in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void displayMetadata(URLConnection conn) {
		System.out.println("Conn timeout " + conn.getConnectTimeout() + " Encoding "+ conn.getContentEncoding() 
				+ " length "+ conn.getContentLength() + " content type "+ conn.getContentType() + " read timeout "+ conn.getReadTimeout());
		System.out.println();
	}
}
