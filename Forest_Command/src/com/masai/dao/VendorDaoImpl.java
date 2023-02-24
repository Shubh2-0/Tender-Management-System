package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Bidder;
import com.masai.dto.BidderImpl;
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
					String number = set.getString(5);
					String city = set.getString(6);
					
					v = new VendorImpl(venid, venpassword, name, email,number, city);
					
				}
			
				if(set==null) throw new VendorException("INVALID ID OR PASSWORD");
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			} finally {
				
		 		try {
					
		 			DBUtils.closeConnection(con);
		 			
				} catch (Exception e2) {
		            
					e2.printStackTrace();

				}
		 		
		 		
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
		
	}	finally {
		
 		try {
			
 			DBUtils.closeConnection(con);
 			
		} catch (Exception e2) {
            
			e2.printStackTrace();

		}
 		
 		
	}
		
		
		
	}
	

	@Override
	public void placeBidAgainstTender(String tender_id, int price) throws TenderException {
	
		try {
			
			con = DBUtils.getConnection();
			String INSERT_QUERY = "INSERT INTO BIDDER(vender_id , tender_id , br_price) VALUES(?,?,?)";
			
			PreparedStatement statement = con.prepareStatement(INSERT_QUERY);
			
			statement.setString(1,ID);
			statement.setString(2, tender_id);
			statement.setInt(3, price);
			
			int num = statement.executeUpdate();
			
			if(num > 0) System.out.println("BIDDED SUCCESSFULLY");
			else System.out.println("NOT ANY TENDER FOUND WITH THIS "+tender_id);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				DBUtils.closeConnection(con);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			
		}
		
		
		
		
	}

	
	@Override
	public Bidder viewStatusOfBid(String BidId) throws BidderException {
        Bidder bid = null;
		try {
			con = DBUtils.getConnection();
			String SELECT_QUERY = "SELECT * FROM BIDDER WHERE br_id = ?";
			
			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
			
			statement.setString(1,BidId);
			
			ResultSet set = statement.executeQuery();
			
			if(set.next()) {
			
			String id = set.getString(1);
			String ten_id = set.getString(2);
			String ven_id = set.getString(3);
			int price = set.getInt(4);
			String status = set.getString(5);
			
			bid = new BidderImpl(id,ten_id,ven_id,price,status);
			
			System.out.println(bid);	
				
				
			}else {
				
				System.out.println("NO BIDDER IS FOUND WITH THIS ID "+BidId);
				
			}
			
		
			
		} catch (Exception e) {
		    
			e.printStackTrace();
		}
		finally {
			try {
				DBUtils.closeConnection(con);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		
		
		return bid;
	}


	@Override
	public List<Bidder> viewOwnBidHistory() throws BidderException {
	List<Bidder> list = new ArrayList<>();
	
	try {
		con = DBUtils.getConnection();
		String SELECT_QUERY = "SELECT * FROM BIDDER WHERE br_id = ?";
		
		PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
		statement.setString(1, ID);
		
		ResultSet set = statement.executeQuery();
		
		while(set.next()) {
			
			String bid_id = set.getString(1);
			String ten_id = set.getString(2);
			String ven_id = set.getString(3);
			int price = set.getInt(4);
			String status = set.getString(5);
			
			Bidder b = new BidderImpl(bid_id, ten_id, ven_id, price, status);
			
			list.add(b);
			
		}
		
		if(list.size()==0) System.out.println("NO BIDS FOUND!");
		
				
		
		
	} catch (Exception e) {
		
		e.printStackTrace();
		
	}finally {
		
		try {
			DBUtils.closeConnection(con);
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
	}
		
		
		
		return list;
	}

}
