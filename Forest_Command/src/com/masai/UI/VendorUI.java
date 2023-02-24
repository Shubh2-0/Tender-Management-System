package com.masai.UI;

import java.util.Scanner;

import com.masai.users.VendorUser;

public class VendorUI {

	static Scanner sc = new Scanner(System.in);
	static VendorUser vender = new VendorUser();
	
	public static int options() {
	
   System.out.println("SELECT");
   System.out.println(
		   

			"PRESS 1 FOR VIEW ALL THE CURRENT TENDERS\n"+
			"PRESS 2 FOR PLACE A BID AGAINST A TENDER\n"+
			"PRESS 3 FOR VIEW STATUS OF BID\n"+
			"PRESS 4 FOR VIEW BIDS HISTORY\n\n\n"+

			"PRESS 0 FOR LOGOUT\n"+
            "PRESS 100 FOR EXIT"
		   
		   
		   );
       
     int choice = sc.nextInt();
     
     
     return choice;
   

		
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
    	break;
    
    case 2 :
    	vender.placeABidAgainstTender();
    	break;
    
    case 3 :
    	vender.viewCurrentStatusOfBid();
    	break;
    
    case 4 :
    	vender.viewOwnBidHistory();
    	break;
    	
    default :
    	System.out.println("THANKS FOR USING OUR SERVICES VISIT AGAIN....😊😊");
    
		
		
	
		
	}
	
	
	
}
