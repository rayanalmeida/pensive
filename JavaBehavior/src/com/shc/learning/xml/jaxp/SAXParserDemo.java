package com.shc.learning.xml.jaxp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserDemo {

	public void process() {

		try {
			File xmlFile = new File("./resources/SAX.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			//SAXParserFactory factory = SAXParserFactory.newInstance("org.apache.SpecialParser", null);

			factory.setNamespaceAware(true);
			//factory.setValidating(true);
//			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//			Schema schema = sf.newSchema(new File("./resources/sax.xsd"));
//			factory.setSchema(schema);

			SAXParser parser = factory.newSAXParser();
			parser.getXMLReader().setErrorHandler(new CustomErrorHandler());
			parser.getXMLReader().setContentHandler(new CustomContentHandler());
//			parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
//			parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaSource", "./resources/sax.xsd");
			
			long start = System.currentTimeMillis();
			parser.getXMLReader().parse(new InputSource(new FileInputStream(xmlFile)));
			long end = System.currentTimeMillis();
			System.out.println("Time taken = " +(end-start)+ "ms");
			
			System.out.println("Total memory " +Runtime.getRuntime().totalMemory());
			System.out.println("Free memory " +Runtime.getRuntime().freeMemory());
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private class CustomContentHandler extends DefaultHandler {
		
		int targets, property;
		boolean delete = false;

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			if(delete) {
				StringBuffer sb = new StringBuffer();
				for(int i=0; i < length; i++) {
					sb.append(ch[start+i]);
				}
				System.out.println(sb);
			}
			super.characters(ch, start, length);
		}

		@Override
		public void endDocument() throws SAXException {
			System.out.println("End of Process");
			super.endDocument();
			System.out.println("Targets "+targets);
			System.out.println("Property "+property);
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			if(qName.equalsIgnoreCase("delete")) {
				delete = false;
			}
			super.endElement(uri, localName, qName);
		}

		@Override
		public void startDocument() throws SAXException {
			
			System.out.println("Start of process");
			super.startDocument();
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			
			if(qName.equalsIgnoreCase("target")){
				++targets;
				
			} else if(qName.equalsIgnoreCase("property")) {
				++property;
				
			} else if (qName.equalsIgnoreCase("delete")) {
				delete = true;
				
			} else if (qName.equalsIgnoreCase("javac")) {
				System.out.println("Total attributes "+attributes.getLength());
				for(int i=0; i < attributes.getLength(); i++) {
					String name = attributes.getLocalName(i);
					if(name.equalsIgnoreCase("classpathref")) {
						String value = attributes.getValue(i);
						System.out.println("Attribute value "+value);
					}
				}
			}
			super.startElement(uri, localName, qName, attributes);
		}

		@Override
		public void ignorableWhitespace(char[] arg0, int arg1, int arg2)
				throws SAXException {
			//Do nothing
			//super.ignorableWhitespace(arg0, arg1, arg2);
		}
		
	}
	private class CustomErrorHandler extends DefaultHandler {

		@Override
		public void error(SAXParseException e) throws SAXException {
			// TODO Auto-generated method stub
			System.out.println("Error");
			e.printStackTrace();
			super.error(e);
		}

		@Override
		public void fatalError(SAXParseException e) throws SAXException {
			// TODO Auto-generated method stub
			System.out.println("FATAL");
			super.fatalError(e);
		}

		@Override
		public void warning(SAXParseException e) throws SAXException {
			// TODO Auto-generated method stub
			System.out.println("warning..");
			super.warning(e);
		}
	}
}
