package com.masai.users;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.masai.colorConsole.ColorConsole;
import com.masai.dao.VendorDao;
import com.masai.dao.VendorDaoImpl;
import com.masai.dto.Bidder;
import com.masai.dto.BidderImpl;
import com.masai.dto.Tender;
import com.masai.dto.TenderImpl;
import com.masai.dto.Vendor;
import com.masai.dto.VendorImpl;
import com.masai.sorting.Sorting;

public class VendorUser {

public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
public static VendorDao vendordao = new VendorDaoImpl();
public static Vendor vendor = new VendorImpl();
public static int limitpass = 0;

public static boolean logInVendor(){
	
	
	
	try {
		System.out.print("ENTER YOUR ID HERE : ");
		String id = br.readLine();
		System.out.print("ENTER YOUR PASSWORD HERE : ");
		String pass = br.readLine();
		vendor = vendordao.logInByVendor(id, pass);
		
		if(vendor.getId()!=null) {
			return true;	
		}else {
			return false;
		}
		
		
	} catch (Exception e) {
       
		System.out.println("INVALID ID OR PASSWORD");
		

	}
	
	return false;
	
}

public static void viewCurrentTender() {
	List<TenderImpl> list = new ArrayList<>();
	try {
		
		list = vendordao.viewAllTender();
		
		ColorConsole.listPreview();
		list.forEach(e -> System.out.println(e));
		
         
		Sorting.chooseTender(list);
		
		
		
		
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
		
	}finally {
		ColorConsole.reset();
	}
	
	
}
	
public static void placeABidAgainstTender() {
	

try {
	System.out.print("CREATED A NEW BIDDER ID : ");
	String id = br.readLine();
	System.out.print("ENTER TENDER ID : ");
	String tr = br.readLine();
	System.out.print("ENTER BIDDING PRICE HERE : ");
	int price = Integer.parseInt(br.readLine());
	
    BidderImpl br = new BidderImpl(id, tr, tr, price, "Not Selected");
	vendordao.placeBidAgainstTender(br);
	
} catch (Exception e) {
	
	System.out.println(e.getMessage());
}
	
	
	
}

public static void viewCurrentStatusOfBid(){

	
	try {
		System.out.print("ENTER THE BIDDER ID HERE : ");
		String id = br.readLine();
		vendordao.viewStatusOfBid(id);
		
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
		
	}
	
	
	
}

public static void viewOwnBidHistory() {
    List<Bidder> list = new ArrayList<>();
	try {
		
		list = vendordao.viewOwnBidHistory();
		
		ColorConsole.listPreview();
		list.forEach(e -> System.out.println(e));
		Sorting.chooseBidder(list);
	
		
		
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
		
	}
	
	
	ColorConsole.reset();

	
	
}


public static void changePasswordOfVendor() {
	
	try {
	
		System.out.print("ENTER OLD PASSWORD : ");
		String old = br.readLine();
		
		if(old.equals(vendor.getPassword())) {
		
			System.out.println("ENTER NEW PASSWORD : ");
			String newpass = br.readLine();
			
			vendordao.changePasswordVendor(newpass);
			
			limitpass = 0;
			
			
		}else {
			if(limitpass < 5) {
				System.out.println("OLD PASSWORD IS NOT MATCH.... TRY AGAIN");
				changePasswordOfVendor();
				limitpass = limitpass+1;	
			}else {
				
				System.out.println("TRY LIMIT EXCEEDED... PLEASE CHANGE PASSWORD AFTER SOME TIME");
				
				
			}
			
		}
		
		
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
		
	}
	
	
	
	
}

	
}
