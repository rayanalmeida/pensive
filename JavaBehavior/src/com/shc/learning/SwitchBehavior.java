package com.shc.learning;

public class SwitchBehavior {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		validateSwitch(5);
	}

	public static void validateSwitch(int value) {

		for(int i = 0; i < 10; i++) {
			switch (value) {
			case 1: {
				System.out.println("VGC");
			}
			break;
			case 2: {
				System.out.println("RGC");
			}
			break;
			}
			System.out.println("running loop");
		}

	}

}
