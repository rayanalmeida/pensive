package com.shc.learning;

public final class Singleton {
	
	private static final Singleton instance = null;
	//disable access
	private Singleton() {
		
	}
	
	public static synchronized Singleton getInstance() {
		return null == instance? new Singleton() : instance;
	}
	

}
