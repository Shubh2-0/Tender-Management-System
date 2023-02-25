package com.masai.UI;

import java.io.IOException;
import java.util.Scanner;

import com.masai.users.AdminstratorUser;
import com.masai.users.VendorUser;

public class MainUI {
	
	static final String GREEN ="\u001B[32m";	
	public static final String bold = "\u001b[1m";
	public static final String reset = "\u001B[0m";
    public static final String italic = "\u001b[3m";

    public static final String black = "\u001b[30m";
    public static final String blue = "\u001b[34m";

public static void admin() {	

int i = 0;
while(i<6) {

	if(AdminstratorUser.LogInAdmin()) AdministratorUI.operations();
  
	else if(i<5) System.out.println("INVALID ID OR PASSWORD");
	
	else {
		System.out.println("TRY LIMIT EXCEEDED PLAESE LOGIN AFTER SOMETIME");
		return;
	}
	
	i++;
	
	
}
	
	
	
}

public static void vendor() {

int i = 0;

while(i<6) {

if(VendorUser.logInVendor()) VendorUI.operations();

else if(i<5) System.out.println("INVALID ID OR PASSWORD");

else {
	System.out.println("TRY LIMIT EXEEDED PLEASE LOGIN AFTER SOMETIME");
	return;
}
	
}

}


	

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);	
	
System.out.println(reset+bold+italic+GREEN+"\t\t\t\t  🌳 WELCOME TO FOREST COMMAND 🌳 ");
System.out.println("\t\t\tTHE BEST PLACE FOR MANAGING TENDERS \n\n");

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
	System.out.println("ENETER YOUR VENDOR ID AND PASSWORD TO LOGIN \n\n");
	vendor();
	return;
	
case 0 :
	System.out.println(reset+italic+blue+"THANKYOU FOR USING OUR SERVICES VIST AGAIN......😁💖");
	System.exit(0);
	return;

	
default : 
	System.out.println("INVALID SELECTION! PLEASE ENTER A VALID OPTION ");
	main(args);



}

	
	
}
	
	
	
}
