package com.shc.learning;

public class ClockAngle {

	public static void main(String[] args) {
		findAngle(11, 50);
	}

	public static void findAngle(float hr, float min) {
		if(hr <= 0 || hr > 12 || min < 0 || min >= 60)
			System.out.println("invalid data");
		
		if (hr == 12) hr = 0;
		
		float angle = min*6 - (hr*30) - min/2;

		if((min <= hr*5) || hr == 12) {
			angle=angle*(-1);
		} 
		System.out.println("the angle is "+angle);
	}

}
