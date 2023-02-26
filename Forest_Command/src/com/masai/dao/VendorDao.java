package com.masai.dao;

import java.util.List;

import com.masai.dto.Bidder;
import com.masai.dto.Tender;
import com.masai.dto.TenderImpl;
import com.masai.dto.Vendor;
import com.masai.exception.BidderException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;

public interface VendorDao {

	public Vendor logInByVendor(String id , String password) throws VendorException;
	
	public List<TenderImpl> viewAllTender() throws TenderException;
	
	public void placeBidAgainstTender(String tender_id , int price) throws TenderException;
	
	public Bidder viewStatusOfBid(String BidId) throws BidderException;
	
	public List<Bidder> viewOwnBidHistory() throws BidderException;
	
	public void changePasswordVendor(String newPassword);
	
}
