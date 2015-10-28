package com.shc.learning;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Reference;

public class JNDILearning {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {

		try {
			Hashtable<String, Object> env = new Hashtable<String, Object>();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
			env.put(Context.PROVIDER_URL, "file:\\");

			String s = "Hello";
			Long l = 12345L;
			
			Reference ref = new Reference(String.class.toString());
			//ref.add()
			
			Context ctx = new InitialContext(env);
			ctx.bind("String", ref);
			//ctx.bind("Long", 123456L);

			System.out.println(ctx.list("String"));
			System.out.println(ctx.listBindings("String"));
			System.out.println(ctx.lookup("Long"));
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
