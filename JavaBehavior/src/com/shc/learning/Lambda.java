package com.shc.learning;

import java.util.LinkedList;
import java.util.List;

public class Lambda {

	public interface PreCheck {
		public boolean validData(int i);
	}
	public static void main(String[] args) {
		
		List<Integer> items = new LinkedList<Integer>();
		items.add(1);
		items.add(2);
		items.add(3);
		
		printDataWithAnnonymousClass(items, new PreCheck() { 
			public boolean validData(int i) {
				return i > 2;
			}
		});
		
		printDataWithLambda(items, (i) -> i > 2);
		
		items.forEach(e -> System.out.println(e));
		items.stream().forEach(e -> System.out.println(e));

		Comparator<Integer> normal = Integer::compare;
		Comparator<Integer> reversed = normal.reversed(); 
		Collections.sort(listOfIntegers, reversed);
	}
	
	private static void printDataWithAnnonymousClass(List<Integer> data, PreCheck p) {
		
		for(Integer i : data) {
			if(p.validData(i)) {
				System.out.println(i);
			}
		}
	}
	
	private static void printDataWithLambda(List<Integer> data, PreCheck p) {
		for(Integer i : data) {
			
		}
	}
	
	//define a functional interface
	@FunctionalInterface
	public interface WorkerInterface {
	 
	    public void doSomeWork();
	 
	}
	 
	/**
	 * Other example 
	 * @author Rayan
	 *
	 */
	public static class WorkerInterfaceTest {
	 
	    public static void execute(WorkerInterface worker) {
	        worker.doSomeWork();
	    }
	 
	    public static void main(String [] args) {
	 
	        //invoke doSomeWork using Annonymous class
	        execute(new WorkerInterface() {
	            @Override
	            public void doSomeWork() {
	                System.out.println("Worker invoked using Anonymous class");
	            }
	        });
	     
	        //invoke doSomeWork using Lambda expression 
	        execute( () -> System.out.println("Worker invoked using Lambda expression") );
	    }
	 
	}
}
