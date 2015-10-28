package com.shc.learning;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public class FileOperation {

	public static void main(String[] args) throws Exception {
		writeFile();
		readFile();
		
	}

	private static void writeFile() {
		
		try {
			 
			OutputStream out = new BufferedOutputStream(new FileOutputStream(new File("")));
			Closeable stream = out;
			
			Writer writer = new OutputStreamWriter(out, Charset.forName("UTF-8"));
			stream = writer;
			
			writer.write("");
			
			stream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void readFile() {
		
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(new File("")));
			Closeable stream = is;
			
			Reader reader = new InputStreamReader(is, Charset.forName("UTF-8"));
			stream = reader;
			
			StringBuffer sb = new StringBuffer(1024);
			char[] data = new char[1024];

			while(true) {
				try {
					int count = reader.read(data);
					if(count < 0) {
						break;
					}
					sb.append(data, 0, count);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			stream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/*Writer
FileWriter
BufferedWriter

Reader
FileReader
BufferedReader

OutputStream
FileOutputStream
BufferedOutputStream

InputStream
FileInputStream
BufferedInputStream

InputStreamReader
OutputStreamWriter*/