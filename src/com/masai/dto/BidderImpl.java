package com.masai.dto;

import java.util.Objects;

public class BidderImpl implements Bidder{

	private String id;
	private String vendorId;
	private String tendenId;
	private int price;
	private String status;
	public BidderImpl() {
		super();
	}
	public BidderImpl(String id, String venderId, String tendenId, int price, String status) {
		super();
		this.id = id;
		this.vendorId = venderId;
		this.tendenId = tendenId;
		this.price = price;
		this.status = status;
	}
	@Override
	public String toString() {
		return "BIDDER ID : "+ id + "\tVENDER ID : " + vendorId + "\t TENDER ID : " + tendenId + "\tPRICE : " + price
				+ "\tSTATUS : " + status+"\t";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, price, status, tendenId, vendorId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BidderImpl other = (BidderImpl) obj;
		return Objects.equals(id, other.id) && price == other.price && Objects.equals(status, other.status)
				&& Objects.equals(tendenId, other.tendenId) && Objects.equals(vendorId, other.vendorId);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVenderId() {
		return vendorId;
	}
	public void setVenderId(String venderId) {
		this.vendorId = venderId;
	}
	public String getTendenId() {
		return tendenId;
	}
	public void setTendenId(String tendenId) {
		this.tendenId = tendenId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
