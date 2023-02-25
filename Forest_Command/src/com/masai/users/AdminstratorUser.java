package com.masai.users;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.masai.dao.AdministratorDao;
import com.masai.dao.AdministratorDaoImpl;
import com.masai.dto.Administrator;
import com.masai.dto.AdministratorImpl;
import com.masai.dto.Tender;
import com.masai.dto.TenderImpl;
import com.masai.dto.Vendor;
import com.masai.dto.VendorImpl;


public class AdminstratorUser{

public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
public static Administrator admin = new AdministratorImpl();	
public static AdministratorDao admindao = new AdministratorDaoImpl();	
public static int tryCount = 0;
		
static final String GREEN ="\u001B[32m";	
public static final String bold = "\u001b[1m";
public static final String reset = "\u001B[0m";
public static final String italic = "\u001b[3m";
public static final String black = "\u001b[30m";
public static final String yellow = "\u001b[33m";
public static final String blue = "\u001b[34m";

public static boolean LogInAdmin(){
   
	 
	  AdministratorDao ad = new AdministratorDaoImpl();
	   
	  try {
		  System.out.print("ENTER YOUR ID HERE : ");
		  String id = br.readLine();
		  System.out.print("ENTER YOUR PASSWORD HERE : ");
		  String password = br.readLine();
		  
		admin = ad.logInByAdmin(id, password);
		System.out.println(yellow+"\n\n \t\t\tWELCOME "+admin.getName().toUpperCase()+" 😁 \n\n");
		
		  return true;
	} catch (Exception e) {

		System.out.println(e.getMessage());
		return false;
	}
	  
	  

	  
  }

public static void registerVendor(){
	
 
 try {
	 System.out.print("CREATE NEW VENDOR ID HERE : ");
	 String id = br.readLine();
	 System.out.print("CREATE PASSWORD HERE : ");
	 String pass = br.readLine();
	 System.out.print("ENTER VENDOR NAME HERE : ");
	 String name = br.readLine();
	 System.out.print("ENTER VENDOR MAIL HERE : ");
	 String email = br.readLine();
	 System.out.print("ENTER MOBILE NUMBER HERE : ");
	 String number = br.readLine();
	 System.out.print("ENTER CITY HERE : ");
	 String city = br.readLine();
	 
	 Vendor vendor = new VendorImpl(id, pass, name, email, number, city);
	  
	admindao.registerVender(vendor);
} catch (Exception e) {
 
  System.out.println(e.getMessage());

}
  	
	  
  }
  
public static void viewAllVenders() {

try {
	admindao.viewAllVendors();
} catch (Exception e) {
	e.getMessage();
}	
	
	
}

public static void createTender(){

	
	try {
		System.out.print("CREATE NEW TENDER ID HERE : ");
		String id = br.readLine();
		System.out.print("ENETR TENDER NAME HERE : ");
		String name = br.readLine();
		System.out.print("TENDER TYPE : ");
		String type = br.readLine();
		System.out.print("TENDER PRICE : ");
		int price = Integer.parseInt(br.readLine());
		System.out.print("TENDER LOCATION : ");
		String city = br.readLine();
		
		
		Tender tender = new TenderImpl(id, name, type, price, city);
		admindao.makeTender(tender);
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
		
	}
	
}

public static void viewAllTender() {

	try {
		
		admindao.viewAllTenders();
		
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
	
	}
	
	
}
	
public static void viewAllBidsOfTender(){
	
	
	try {
		System.out.println("ENTER TENDER ID HERE : ");
		String id = br.readLine();
		admindao.viewAllBidsOfTenders(id);
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
	}
	
}

public static void assignTenderToVender(){
	
	
	try {
		System.out.println("ENTER VENDER ID : ");
		String venid = br.readLine();
		System.out.println("ENTER TENDER ID : ");
		String tenid = br.readLine();
		
		admindao.assignTenderToVender(venid, tenid);
		
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
      		
	}
	
	
}

public static void changePassword() {
	
	try {
		
		System.out.print("ENTER CURRENT PASSWORD : ");
		String current = br.readLine();
		String id = admin.getId();
		if(current.equals(admin.getPassword())) {
			System.out.print("ENTER NEW PASSWORD : ");
			String newPassword = br.readLine(); 
			admindao.changePassword(newPassword , id);
			tryCount = 0;
		}else {
			if(tryCount < 5) {
				System.out.println("PASSWORD IS NOT MATCH PLEASE TRY AGAIN....");
				tryCount = tryCount+1;
				changePassword();
			}else {
				System.out.println("TRY LIMIT EXEDED PLEASE TRY AFTER SOME TIME....");
			}
			
		}
		
	} catch (Exception e) {
	
		System.out.println(e.getMessage());
	}
	
}

}
