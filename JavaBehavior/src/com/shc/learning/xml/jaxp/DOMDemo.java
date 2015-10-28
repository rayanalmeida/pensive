package com.shc.learning.xml.jaxp;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMDemo {

	public static void main(String args[]) {
		DOMDemo obj = new DOMDemo();
		obj.parseFile();
	}
	
	public void parseFile() {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			dbf.setValidating(true);
			dbf.setNamespaceAware(true);
			dbf.setIgnoringComments(true);
			dbf.setIgnoringElementContentWhitespace(true);
			Document d = db.parse(new File("./resources/SAX.xml"));

			Element e = d.getDocumentElement();
			System.out.println(e.getNodeName());
			System.out.println(e.getNodeValue());
			
			NodeList nl =  e.getChildNodes();
			for(int i=0; i < nl.getLength(); i++) {
			System.out.println(nl.item(i).getNodeName());
			System.out.println(nl.item(i).getNodeValue());
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
