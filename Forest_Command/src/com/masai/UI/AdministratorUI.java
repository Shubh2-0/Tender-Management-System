package com.masai.UI;

import java.util.Scanner;

import com.masai.users.AdminstratorUser;


public class AdministratorUI {

   
	static Scanner sc = new Scanner(System.in);
   
	static final String GREEN ="\u001B[32m";	
	public static final String bold = "\u001b[1m";
	public static final String reset = "\u001B[0m";

    public static final String italic = "\u001b[3m";

    public static final String black = "\u001b[30m";
    public static final String blue = "\u001b[34m";
	
	public static int options() {
	
	System.out.println(GREEN+"PLEASE SELECT ANY OF THEM");
	System.out.println(
			
			"PRESS 1 FOR REGISTER A NEW VENDER\n"+
			"PRESS 2 FOR VIEW ALL VENDERS\n"+
			"PRESS 3 CREATE A NEW TENDER\n"+
			"PRESS 4 VIEW ALL TENDERS\n"+
			"PRESS 5 VIEW ALL THE BIDDS OF A TENDER\n"+
			"PRESS 6 ASSIGN TENDER TO A VENDER\n"+
			"PRESS 7 FOR CHANGING PASSWORD\n\n"+
			"PRESS 0 FOR LOGOUT\n"+
            "PRESS 100 FOR EXIT\n\n"
			
			);
	
	int choice = sc.nextInt();
	
	
	return choice;
		
	
	}
	
    
	public static void operations() {
	
	int choice = options();
	
    
    switch(choice) {
    
    case 0 :
    	System.out.println("Logout SUCCESSFULLLY....");
    	MainUI.main(null);
    	break;
    
    case 1 :
    	AdminstratorUser.registerVendor();
    	operations();
    	break;
    
    case 2 :
    	AdminstratorUser.viewAllVenders();
    	operations();
    	break;
    
    case 3 :
    	AdminstratorUser.createTender();
    	operations();
    	break;
    
    case 4 :
    	AdminstratorUser.viewAllTender();
    	operations();
    	break;
    
    case 5 :
    	AdminstratorUser.viewAllBidsOfTender();
    	operations();
    	break;
    
    case 6 :
    	AdminstratorUser.assignTenderToVender();
    	operations();
    	break;
    
    case 7 :
    	AdminstratorUser.changePassword();
    	
    default :
    	System.out.println("THANKS FOR USING OUR APPLICATION VISIT AGAIN");
    
    
    
    }
	
	
		
	}
	
	
	
}
