package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.masai.dto.Administrator;
import com.masai.dto.AdministratorImpl;
import com.masai.dto.Bidder;
import com.masai.dto.BidderImpl;
import com.masai.dto.Tender;
import com.masai.dto.TenderImpl;
import com.masai.dto.Vendor;
import com.masai.dto.VendorImpl;
import com.masai.exception.AdministratorException;
import com.masai.exception.BidderException;
import com.masai.exception.TenderException;
import com.masai.exception.VendorException;
import com.masai.utility.DBUtils;


public class AdministratorDaoImpl implements AdministratorDao {
	
	static final String GREEN ="\u001B[32m";	
	public static final String bold = "\u001b[1m";
	public static final String reset = "\u001B[0m";
    public static final String italic = "\u001b[3m";
    public static final String black = "\u001b[30m";
    public static final String bgBrightWhite = "\u001b[47;1m";
    public static final String blue = "\u001b[34m";	
    public static final String underline = "\u001b[4m";
    
	static Connection con = null;
	
	@Override
	public AdministratorImpl logInByAdmin(String id, String password) throws AdministratorException {
	AdministratorImpl admin = null;
	
	
	try {
		con = DBUtils.getConnection();
		
		String SELECT_QUERY = "SELECT * FROM ADMINISTRATOR WHERE AD_ID = ? AND AD_PASSWORD = ?";
		PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
		
		statement.setString(1, id);
		statement.setString(2, password);
		
		ResultSet set = statement.executeQuery();
		
		if(set.next()) {
		    String adminId = set.getString("ad_id");
			String name = set.getString("ad_name");
			String email = set.getString("ad_email");
			String city = set.getString("ad_city");
			String pass = set.getString("ad_password");
			
			admin = new AdministratorImpl(adminId ,name, email, city , pass);
			
		}else {
			
			
			throw new AdministratorException("NO ADMIN IS FOUND FOR THIS ID AND PASSWORD");
			
		}
		

	} catch (SQLException e) {
		
		e.printStackTrace();
		
	}finally {
		
		try {
			DBUtils.closeConnection(con);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	
	
	
	
		
		
   
	return admin;
	
	
	}

	
	@Override
	public void registerVender(Vendor v) throws VendorException {

		
	try {
		
		con = DBUtils.getConnection();
		
		String INSERT_QUERY = "INSERT INTO VENDOR VALUES(?,?,?,?,?,?)";
		PreparedStatement statement = con.prepareStatement(INSERT_QUERY);
		
		statement.setString(1, v.getId());
		statement.setString(2, v.getPassword());
		statement.setString(3, v.getName());
		statement.setString(4, v.getEmail());
		statement.setString(5, v.getNumber());
		statement.setString(6, v.getCity());
		
		int n = statement.executeUpdate();
		
		if(n > 0) System.out.println("VENDER SUCCESSFULLY ADDED TO DATABASE");		
		
		else throw new VendorException("SOMETHING WENT WRONG");
		
		
		
	} catch (Exception e) {
		
		e.printStackTrace();
		
	} finally {
		
		try {
			
			DBUtils.closeConnection(con);
			
		} catch (Exception e2) {
			
			e2.printStackTrace();
			
		}
		
		
	}
	
	
		
		
		
		
		
		
	}
	
	
	@Override
	public void viewAllVendors() throws VendorException {

	
	try {
		
		con = DBUtils.getConnection();
		String SELECT_QUERY = "SELECT * FROM VENDOR";
		
		PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
		
	
		
		ResultSet set = statement.executeQuery();
		
		if(set==null) throw new VendorException("NO RECORD FOUND");
		System.out.println(underline+bgBrightWhite+bold+black+"\t\tVENDOR ID\t\tPASSOWRD\t\tVENDOR NAmeA\t\t");
		
		while(set.next()) {
		String id = set.getString(1);
		String pass = set.getString(2);
		String name = set.getString(3);
		String email = set.getString(4);
		String number = set.getString(5);
		String city = set.getString(6);
		
		Vendor vr = new VendorImpl(id, pass, name, email,number, city);
			
			System.out.println(vr);
			
		}
		System.out.println("\t\t\t\t\t\t\t\t\t\t.");
		System.out.println(reset+GREEN+bold+"");
		
	} catch (Exception e) {
	
		e.printStackTrace();
 	} finally {
		
 		try {
			
 			DBUtils.closeConnection(con);
 			
		} catch (Exception e2) {
            
			e2.printStackTrace();

		}
 		
 		
	}
	
	
		
		
		
		
		
		
	}

	
	@Override
	public void makeTender(Tender t) throws TenderException {
	

	
	try {
		con = DBUtils.getConnection();
		String INSERT_QUERY = "INSERT INTO TENDER VALUES(?,?,?,?,?)";
		PreparedStatement statement = con.prepareStatement(INSERT_QUERY);
		
		statement.setString(1, t.getId());
		statement.setString(2, t.getName());
		statement.setString(3, t.getType());
		statement.setInt(4, t.getPrice());
		statement.setString(5, t.getCity());
		
		int num = statement.executeUpdate();
		
		if(num > 0) System.out.println("TENDER ADDED SUCCESSFULLY IN DATABASE");
		
		
		
	} catch (Exception e) {
		
		e.printStackTrace();
		throw new TenderException("SOMETHING WENT WRONG NOT ABLE TO INSERTV TENDER INTO DATABASE");
		
	}finally {
		
 		try {
			
 			DBUtils.closeConnection(con);
 			
		} catch (Exception e2) {
            
			e2.printStackTrace();

		}
 		
 		
	}
	
		
		
		
	}	

	
	
	
	@Override
	public void viewAllTenders() throws TenderException {

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
		
		Tender tr = new TenderImpl(id, name, type, price, city);
		
		System.out.println(tr);
			
		}
		
		
		
		if(set == null) throw new TenderException("NO RECORD FOUND IN DATABASE");
		
		
	} catch (Exception e) {
		
		e.printStackTrace();
		
	}finally {
		
 		try {
			
 			DBUtils.closeConnection(con);
 			
		} catch (Exception e2) {
            
			e2.printStackTrace();

		}
 		
 		
	}
		
		
	}

	
	
	
	@Override
	public void viewAllBidsOfTenders(String tender_id) throws BidderException {

		try {
		
			con = DBUtils.getConnection();
             
			String SELECT_QUERY = "SELECT * FROM BIDDER WHERE TENDER_ID = ?";
			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
			
			statement.setString(1, tender_id);
			
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
			
			String id = set.getString(1);
			String vendorId = set.getString(2);
			String tenderID = set.getString(3);
			int price = set.getInt(4);
			String status = set.getString(5);
			
			Bidder bider = new BidderImpl();
			
			System.out.println(bider);
				
				
			}
			
			
			
			if(set==null)  throw new BidderException("NO BIDDER FOUND!");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			
	 		try {
				
	 			DBUtils.closeConnection(con);
	 			
			} catch (Exception e2) {
	            
				e2.printStackTrace();

			}
	 		
	 		
		}
		
		
		
		
	}

	
	
	@Override
	public void assignTenderToVender(String venderId, String tenderId) throws BidderException {
	
		try {
			con = DBUtils.getConnection();
			
			String UPDATE_QUERY = "UPDATE BIDDER SET BR_STATUS = 'select' where VENDER_ID = ? AND TENDER_ID = ?";
			PreparedStatement statement = con.prepareStatement(UPDATE_QUERY);
			
			int num = statement.executeUpdate();
			
			if(num > 0) System.out.println("TENDER ASSIGNED SUCCESSFULLY....");
			
			
			if(num == 0) System.out.println("SOMETHING WENT WRONG NOT ABLE TO ASSIGN");
			
		} catch (Exception e) {
		
			e.printStackTrace();
			
		} finally {
			
	 		try {
				
	 			DBUtils.closeConnection(con);
	 			
			} catch (Exception e2) {
	            
				e2.printStackTrace();

			}
	 		
	 		
		}
		
	
		
		
		
	}


	@Override
	public void changePassword(String password , String id) {
	
	try {
		
		con = DBUtils.getConnection();
		String UPDATE_QUERY = "UPDATE ADMINISTRATOR SET ad_password = ? where ad_id = ?";
		PreparedStatement statement = con.prepareStatement(UPDATE_QUERY);
		
		statement.setString(1, password);
		statement.setString(2, id);
		
		int num = statement.executeUpdate();
		
		if(num > 0) System.out.println("PASSWORD CHANGED SUSSECCFULLY.....");
		else {
			throw new AdministratorException("NO ADMIN FOUND WITH THID ID "+id);
		}
		
		
	} catch (Exception e) {
		

		e.printStackTrace();
		
		
		
	}	finally {
		
		try {
			
			DBUtils.closeConnection(con);
			
		} catch (Exception e2) {
			
			e2.printStackTrace();
		}
		
		
	}
		
		
	}

	
	
	
}
