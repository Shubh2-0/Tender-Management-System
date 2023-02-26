package com.masai.sorting;

import java.util.List;

import com.masai.dto.Bidder;
import com.masai.dto.Tender;
import com.masai.dto.TenderImpl;

public class Sorting {

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
