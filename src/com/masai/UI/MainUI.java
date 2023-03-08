package com.masai.UI;


import java.io.IOException;
import java.util.Scanner;

import com.masai.colorConsole.ColorConsole;
import com.masai.users.AdminstratorUser;
import com.masai.users.VendorUser;

public class MainUI {

public static int adminCount = 0;	
public static int vendorCount = 0;	


public static void admin() {	



	
while(adminCount<5) {
	
	if(AdminstratorUser.LogInAdmin()) {
		AdministratorUI.operations();
		adminCount=0;
		break;
		
	}
  
	else if(adminCount<3) {
		System.out.println("INVALID ID OR PASSWORD");
		AdminstratorUser.LogInAdmin();
		adminCount+=1;
		
	}
	
	else {
		System.out.println("TRY LIMIT EXCEEDED PLAESE LOGIN AFTER SOMETIME");
		System.exit(0);
	}
	
	
	
}
	
	
	
}

public static void vendor() {
	
	while(vendorCount<4) {
		
		if(VendorUser.logInVendor()) {
			VendorUI.operationsVendors();
			vendorCount=0;
			return;
		}
	  
		else if(vendorCount<3) {
			System.out.println("INVALID ID OR PASSWORD");
			vendor();
			vendorCount+=1;
			
		}
		
		else {
			System.out.println("TRY LIMIT EXCEEDED PLAESE LOGIN AFTER SOMETIME");
			System.exit(0);
		}
		
		
		
	}	
	
	
}



	

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);	
ColorConsole.reset();	
System.out.println("\t\t\t  🌳 WELCOME TO FOREST COMMAND 🌳 ");
System.out.println("\t\t\t  BEST PLACE FOR MANAGING TENDERS \n\n");

System.out.println("SELECT A VALID OPTION : \n");

System.out.println("PRESS 1 FOR ADMINISTRATOR LOGIN ");
System.out.println("PRESS 2 FOR VENDOR LOGIN \n\n");
System.out.println("PRESS 0 FOR Exit \n\n");
int choice = sc.nextInt();


switch(choice) {


case 1 : 
	System.out.println("ENTER YOUR ADMIN ID AND PASSWORD TO LOGIN \n\n");
    admin();
    return;
	
case 2 : 
	System.out.println("ENTER YOUR VENDOR ID AND PASSWORD TO LOGIN \n\n");
	vendor();
	return;
	
case 0 :
	ColorConsole.exitColor();
	System.out.println("THANKYOU FOR USING OUR SERVICES VIST AGAIN......😁💖");
	System.exit(0);
	return;

	
default : 
	System.out.println("INVALID SELECTION! PLEASE SELECT A VALID OPTION ");
	main(args);



}

	
	
}
	
	
	
}
