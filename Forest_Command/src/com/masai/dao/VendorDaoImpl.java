package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.masai.dto.Bidder;
import com.masai.dto.TenderImpl;
import com.masai.dto.Vendor;
import com.masai.dto.VendorImpl;
import com.masai.exception.BidderException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;
import com.masai.utility.DBUtils;

public class VendorDaoImpl  implements VendorDao{
	
	static Connection con = null;
	static String ID;
	static String PASSWORD;

	@Override
	public Vendor logInByVendor(String id, String password) throws VendorException {
			Vendor v = null;
			
			try {
				con = DBUtils.getConnection();
				
				String SELECT_QUERY = "SELECT * FROM VENDOR WHERE VR_ID = ? AND VR_PASSWORD = ?";
				PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
				
				statement.setString(1, id);
				statement.setString(2, password);
				
				ResultSet set = statement.executeQuery();
				
				if(set.next()) {
					
					String venid = set.getString(1);
					String venpassword = set.getString(2);
					String name = set.getString(3);
					String email = set.getString(4);
					String city = set.getString(5);
					
					v = new VendorImpl(venid, venpassword, name, email, city);
					
				}
				DBUtils.closeConnection(con);
				if(set==null) throw new VendorException("INVALID ID OR PASSWORD");
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
		
		
		
	return v;	
		
	}

	@Override
	public void viewAllTender() throws TenderException {
	
	try {
		
		con = DBUtils.getConnection();
		String SELECT_QUERY = "SELECT * FROM TENDER";
		
		PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
		
		ResultSet set = statement.executeQuery();
		
		while(set.next()) {
		
		String id = set.getString(1);
		String name = set.getString(2);
		String type = set.getString(3);
		int price = set.getInt(4);
		String city = set.getString(5);
		
		TenderImpl tender = new TenderImpl(id, name, type, price, city);
		
		System.out.println(tender);
		}
		
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}	
		
		
		
	}
	
	
	
	
	

	@Override
	public void placeBidAgainstTender(String tender_id, int price) throws TenderException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bidder viewStatusOfBid(String BidId) throws BidderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bidder> viewOwnBidHistory() throws BidderException {
		// TODO Auto-generated method stub
		return null;
	}

}
