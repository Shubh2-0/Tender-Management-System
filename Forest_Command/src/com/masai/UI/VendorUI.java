package com.masai.UI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.masai.dao.VendorDaoImpl;
import com.masai.users.VendorUser;

public class VendorUI {

	static Scanner sc = new Scanner(System.in);
	static VendorUser vender = new VendorUser();
	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	
	public static int options() {
	
   System.out.println("\n\nSELECT ANY ONE OPTION\n");
   System.out.println(
		   

			"PRESS 1 FOR VIEW ALL THE CURRENT TENDERS\n"+
			"PRESS 2 FOR PLACE A BID AGAINST A TENDER\n"+
			"PRESS 3 FOR VIEW CURRENT STATUS OF BID\n"+
			"PRESS 4 FOR VIEW BIDS HISTORY\n"+
			"PRESS 5 FOR CHANGE PASSWORD\n\n"+

			"PRESS 0 FOR LOGOUT\n"+
            "PRESS 100 FOR EXIT"
		   
		   
		   );
       
     try {
		
    	 int choice = Integer.parseInt(br.readLine());
    	 
    	 return choice;
    	 
	} catch (Exception e) {
		// TODO: handle exception
	}
	return 0;
     
     

   

		
	}
	
	
	public static void continueOrExit() {
	
	System.out.println("\nPRESS 1 FOR MAIN MENU");
	System.out.println("PRESS 0 FOR EXIT");
	
	int choice = sc.nextInt();
	
	if(choice==0) {
		System.out.println("THANKS FOR USING OUR SERVICES.......😊");
		System.exit(0);
	}else if(choice==1) {
		VendorUI.options();
	}else {
		System.out.println("INVALID INPUT.....PLEASE SELECT A VALID OPTION");
		continueOrExit();
		
	}
		
		
	}
	
	public static void operations() {
	
	int choice = options();
	
	switch (choice) {
	
	case 0 :
    	System.out.println("Logout SUCCESSFULLLY....");
    	MainUI.main(null);
    	break;
    
    case 1 :
    	vender.viewCurrentTender();
    	VendorUI.continueOrExit();
    	break;
    
    case 2 :
    	vender.placeABidAgainstTender();
    	VendorUI.continueOrExit();
    	break;
    
    case 3 :
    	vender.viewCurrentStatusOfBid();
    	VendorUI.continueOrExit();
    	break;
    
    case 4 :
    	vender.viewOwnBidHistory();
    	VendorUI.continueOrExit();
    	break;
    	
    case 5 :
    	vender.changePasswordOfVendor();
    	VendorUI.continueOrExit();
    	break;
    	
    default :
    	System.out.println("THANKS FOR USING OUR SERVICES VISIT AGAIN....😊😊");
    	MainUI.main(null);
    	break;
    
		
		
	
		
	}
	}
	
	
	}

