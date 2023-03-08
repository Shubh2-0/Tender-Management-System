package com.masai.dao;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.masai.colorConsole.ColorConsole;
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
					ID =id;
					PASSWORD = v.getPassword();
					
					  ColorConsole.welcome();
						System.out.println("WELCOME "+v.getName()+"  😁");
					
				}
				
			  
				
				if(v==null) throw new VendorException("INVALID ID OR PASSWORD");
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			} finally {
				
		 		try {
					
		 			DBUtils.closeConnection(con);
		 			
				} catch (Exception e2) {
		            
					e2.printStackTrace();

				}
		 		
			}
			
		
		
	ColorConsole.reset();	
	return v;	
	
		
	}

	
	@Override
	public List<TenderImpl> viewAllTender() throws TenderException {
		List<TenderImpl> list = new ArrayList<>();
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
		list.add(tender);
		}
		
		if(list.size()==0) {
			throw new TenderException("NO TENDER FOUND IN THE DATABASE"); 
		}
		
		
		
	} catch (Exception e) {
		
	}	finally {
		
 		try {
			
 			DBUtils.closeConnection(con);
 			
		} catch (Exception e2) {
            
			e2.printStackTrace();

		}
 		
 		
	}
		
		return list;
		
	}
	

	@Override
	public void placeBidAgainstTender(BidderImpl br) throws TenderException {
	
		try {
			
			con = DBUtils.getConnection();
			String INSERT_QUERY = "INSERT INTO BIDDER(br_id,vendor_id , tender_id , br_price , br_status) VALUES(?,?,?,?,?)";
			
			PreparedStatement statement = con.prepareStatement(INSERT_QUERY);
			String status = "Not Selected";
			statement.setString(1, br.getId());
			statement.setString(2,ID);
			statement.setString(3, br.getTendenId());
			statement.setInt(4, br.getPrice());
			statement.setString(5, status);
	
			
			int num = statement.executeUpdate();
			
			System.out.println(ColorConsole.blue);
			if(num > 0) System.out.println("BIDDED SUCCESSFULLY......");
			else {
				System.out.println(ColorConsole.RED);
				System.out.println("NOT ANY TENDER FOUND WITH THIS "+br.getTendenId());
			}
			
		} catch (Exception e) {
			
			System.out.println(ColorConsole.RED);
			System.out.println("SOMETHING WENT WRONG......");
			
			
		} finally {
			
			try {
				DBUtils.closeConnection(con);
			} catch (Exception e2) {
				System.out.println(ColorConsole.RED);
				System.out.println("SOMETHING WENT WRONG......");
				
			}
			
			
			ColorConsole.reset();
			
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
				System.out.println(ColorConsole.RED);
				System.out.println("NO BIDDER IS FOUND WITH THIS ID "+BidId);
				
			}
			
		
			
		} catch (Exception e) {
		    
			e.printStackTrace();
		}
		finally {
			try {
				DBUtils.closeConnection(con);
			} catch (Exception e2) {
			
				System.out.println(ColorConsole.RED);
				System.out.println("SOMETHING WENT WRONG......");
			}
		}
		
		
		ColorConsole.reset();
		
		return bid;
	}


	@Override
	public List<Bidder> viewOwnBidHistory() throws BidderException {
	List<Bidder> list = new ArrayList<>();
	
	try {
		con = DBUtils.getConnection();
		String SELECT_QUERY = "SELECT * FROM BIDDER WHERE vendor_id = ?";
		
		PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
		statement.setString(1,ID );
		
		ResultSet set = statement.executeQuery();
		
		while(set.next()) {
			
			String bid_id = set.getString(1);
			String ten_id = set.getString(2);
			String ven_id = set.getString(3);
			int price = set.getInt(4);
			String status = set.getString(5);
			
			Bidder b = new BidderImpl(bid_id, ven_id, ten_id, price, status);
			
			list.add(b);
			
			
		}
		
		System.out.println(ColorConsole.RED);
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
		
		
		ColorConsole.reset();
		return list;
	}

	
	public void changePasswordVendor(String newPassword) {
		
	try {
		con = DBUtils.getConnection();
		String UPDATE_QUERY = "UPDATE VENDOR SET VR_PASSWORD = ? WHERE VR_ID = ?";
		PreparedStatement statement = con.prepareStatement(UPDATE_QUERY);
		
		statement.setString(1, newPassword);
		statement.setString(2, ID);
		
		int num = statement.executeUpdate();
		
		System.out.println(ColorConsole.blue);
		if(num > 0 ) System.out.println("PASSWORD CHANGE SUCCESSFULLY...");
		else {
		System.out.println(ColorConsole.RED);	
			 throw new VendorException("SOMETHING WENT WRONG NOT ABLE TO CHANGE THE PASSWORD");
		}
		
	} catch (Exception e) {
		
	 System.out.println("SOMETHING WENT WRONG");	
		
	} finally {
		
		try {
			DBUtils.closeConnection(con);
		} catch (Exception e2) {
			// TODO: handle exception
		}
		

		ColorConsole.reset();
	}	
		
	}
	
}
