package com.masai.dao;

import java.util.List;

import com.masai.dto.Administrator;
import com.masai.dto.Bidder;
import com.masai.dto.Tender;
import com.masai.dto.TenderImpl;
import com.masai.dto.Vendor;
import com.masai.exception.AdministratorException;
import com.masai.exception.BidderException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;

public interface AdministratorDao {

	public Administrator logInByAdmin(String id , String password) throws AdministratorException;
	
	public void registerVender(Vendor v) throws VendorException;
	
	public void viewAllVendors() throws VendorException;
	
	public void makeTender(Tender t) throws TenderException;
	
	public List<TenderImpl> viewAllTenders() throws TenderException;
	
	public List<Bidder> viewAllBidsOfTenders(String tender_id) throws BidderException;
	
	public void assignTenderToVender(String venderId , String tenderId) throws BidderException;
	
	public void changePassword(String password , String id);
	
	
	
}
