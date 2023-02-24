package com.masai.users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.masai.dao.VendorDao;
import com.masai.dao.VendorDaoImpl;
import com.masai.dto.Vendor;
import com.masai.dto.VendorImpl;

public class VendorUser {

public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
public static VendorDao vendordao = new VendorDaoImpl();
public static Vendor vendor = new VendorImpl();


public static boolean logInVendor(){
	
	
	
	try {
		System.out.println("ENTER YOUR ID HERE : ");
		String id = br.readLine();
		System.out.println("ENTER YOUR PASSWORD HERE : ");
		String pass = br.readLine();
		vendor = vendordao.logInByVendor(id, pass);
		return true;
		
	} catch (Exception e) {
       
		System.out.println(e.getMessage());
		
		return false;

	}
	
	
}

public static void viewCurrentTender() {
	
	try {
		
		vendordao.viewAllTender();
		
		
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
		
	}
	
	
}
	
public static void placeABidAgainstTender() {
	

try {
	System.out.println("ENTER TENDER ID : ");
	String id = br.readLine();
	System.out.println("ENTER BIDDING PRICE HERE : ");
	int price = Integer.parseInt(br.readLine());

	vendordao.placeBidAgainstTender(id, price);
	
} catch (Exception e) {
	
	System.out.println(e.getMessage());
}
	
	
	
}

public static void viewCurrentStatusOfBid(){

	
	try {
		System.out.println("ENTER THE BID SERIAL NUMBER HERE : ");
		String id = br.readLine();
		vendordao.viewStatusOfBid(id);
		
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
		
	}
	
	
	
}

public static void viewOwnBidHistory() {

	try {
		
		vendordao.viewOwnBidHistory();
		
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
		
	}

	
	
}

	
}
