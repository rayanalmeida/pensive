package com.shc.learning;

public class BasicTest {

	public static void main(String[] args) {
		new BasicTest().forloop();
		// TODO Auto-generated method stub

	}
	
	public void forloop() {
		
		for (int i = 0; i < 1070; i = i+100) {
			if (i + 99 < 1070) {
				System.out.println("I: "+i);
				//vendorDetailList.addAll(newSellerDetailsServiceClient.getSellerDetails(sellerList.subList(i, i+100)));
			} else {
				System.out.println("i: "+i);
				//vendorDetailList.addAll(newSellerDetailsServiceClient.getSellerDetails(sellerList.subList(i, sellerList.size())));
			}
		}
	}

}
