package com.masai.sorting;

import java.util.List;
import java.util.Scanner;



import com.masai.UI.AdministratorUI;
import com.masai.UI.VendorUI;
import com.masai.colorConsole.ColorConsole;
import com.masai.dto.Bidder;
import com.masai.dto.TenderImpl;

public class Sorting {
	
	static final Scanner sc = new Scanner(System.in);
	

	public static void chooseBidderad(List<Bidder> list) {
		if(list.size()!=0) {
		    ColorConsole.reset();
			System.out.println("\nPRESS 1 FOR SORTING THE LIST FROM LOW TO HIGH PRICE");
			System.out.println("PRESS 2 FOR SORTING THE LIST FROM HIGH TO LOW PRICE\n");
			System.out.println("PRESS 5 FOR MAIN MENU");
			System.out.println("PRESS 0 FOR EXIT\n\n");
			int choice = sc.nextInt();
			
			if(choice==2) {
				ColorConsole.listPreview();
				Sorting.highToLowPriceBidder(list);
				list.forEach(e -> System.out.println(e));		
			}else if (choice==1) {
				ColorConsole.listPreview();
				Sorting.lowToHighPriceBidder(list);
				list.forEach(e -> System.out.println(e));
			}else if(choice==5){
				
				AdministratorUI.operations();
				
			}else if(choice == 0) {
				
				System.out.println("THANKS FOR USING OUR SERVICES.....");
				System.exit(0);
				
			}else {
				
				System.out.println("PLEASE SELECT A VALID OPTION..");
				chooseBidderad(list);
				
			}
			
		}
	}
	
	
	public static void chooseTenderad(List<TenderImpl> list) {
		if(list.size()!=0) {
		    ColorConsole.reset();
			System.out.println("\nPRESS 1 FOR SORTING THE LIST FROM LOW TO HIGH PRICE");
			System.out.println("PRESS 2 FOR SORTING THE LIST FROM HIGH TO LOW PRICE\n");
			System.out.println("PRESS 5 FOR MAIN MENU");
			System.out.println("PRESS 0 FOR EXIT\n\n");
			int choice = sc.nextInt();
			
			if(choice==2) {
				ColorConsole.listPreview();
				Sorting.highToLowPriceTender(list);
				list.forEach(e -> System.out.println(e));		
			}else if (choice==1) {
				ColorConsole.listPreview();
				Sorting.lowTohighPriceTender(list);
				list.forEach(e -> System.out.println(e));
			}else if(choice==5){
				
				AdministratorUI.operations();
				
			}else if(choice == 0) {
				
				System.out.println("THANKS FOR USING OUR SERVICES.....");
				System.exit(0);
				
			}else {
				
				System.out.println("PLEASE SELECT A VALID OPTION..");
				chooseTenderad(list);
				
			}
			
		}
	}
	
	
	
	public static void chooseBidderven(List<Bidder> list) {
		if(list.size()!=0) {
		    ColorConsole.reset();
			System.out.println("\nPRESS 1 FOR SORTING THE LIST FROM LOW TO HIGH PRICE");
			System.out.println("PRESS 2 FOR SORTING THE LIST FROM HIGH TO LOW PRICE\n");
			System.out.println("PRESS 5 FOR MAIN MENU");
			System.out.println("PRESS 0 FOR EXIT\n\n");
			int choice = sc.nextInt();
			
			if(choice==2) {
				ColorConsole.listPreview();
				Sorting.highToLowPriceBidder(list);
				list.forEach(e -> System.out.println(e));		
			}else if (choice==1) {
				ColorConsole.listPreview();
				Sorting.lowToHighPriceBidder(list);
				list.forEach(e -> System.out.println(e));
			}else if(choice==5){
				
				VendorUI.operationsVendors();
				
			}else if(choice == 0) {
				
				System.out.println("THANKS FOR USING OUR SERVICES.....");
				System.exit(0);
				
			}else {
				
				System.out.println("PLEASE SELECT A VALID OPTION..");
				chooseBidderven(list);
				
			}
			
		}
	}
	
	
	
	public static void chooseTenderven(List<TenderImpl> list) {
		if(list.size()!=0) {
		    ColorConsole.reset();
			System.out.println("\nPRESS 1 FOR SORTING THE LIST FROM LOW TO HIGH PRICE");
			System.out.println("PRESS 2 FOR SORTING THE LIST FROM HIGH TO LOW PRICE\n");
			System.out.println("PRESS 5 FOR MAIN MENU");
			System.out.println("PRESS 0 FOR EXIT\n\n");
			int choice = sc.nextInt();
			
			if(choice==2) {
				ColorConsole.listPreview();
				Sorting.highToLowPriceTender(list);
				list.forEach(e -> System.out.println(e));		
			}else if (choice==1) {
				ColorConsole.listPreview();
				Sorting.lowTohighPriceTender(list);
				list.forEach(e -> System.out.println(e));
			}else if(choice==5){
				
				VendorUI.operationsVendors();
				
			}else if(choice == 0) {
				
				System.out.println("THANKS FOR USING OUR SERVICES.....");
				System.exit(0);
				
			}else {
				
				System.out.println("PLEASE SELECT A VALID OPTION..");
				chooseTenderven(list);
				
			}
			
		}
	}
	
	
	
	public static void highToLowPriceBidder(List<Bidder> br) {
	
	br.sort( (e1,e2) -> e2.getPrice() - e1.getPrice() );	
		
		
	}
	
	public static void lowToHighPriceBidder(List<Bidder> br) {
	
	br.sort( (e1,e2) -> e1.getPrice() - e2.getPrice());	
		
	}
	
	public static void highToLowPriceTender(List<TenderImpl> tr) {
	
	tr.sort( (e1,e2 ) -> e2.getPrice() - e1.getPrice());	
		
	}
	
	
	public static void lowTohighPriceTender(List<TenderImpl> list) {
		
		list.sort( (e1,e2 ) -> e1.getPrice() - e2.getPrice());	
			
	}


	
}
