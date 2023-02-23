package com.masai.dto;

import java.util.Objects;

public class BidderImpl implements Bidder{

	private String id;
	private String venderId;
	private String tendenId;
	private int price;
	private String status;
	public BidderImpl() {
		super();
	}
	public BidderImpl(String id, String venderId, String tendenId, int price, String status) {
		super();
		this.id = id;
		this.venderId = venderId;
		this.tendenId = tendenId;
		this.price = price;
		this.status = status;
	}
	@Override
	public String toString() {
		return "BinnedImp [id=" + id + ", venderId=" + venderId + ", tendenId=" + tendenId + ", price=" + price
				+ ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, price, status, tendenId, venderId);
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
				&& Objects.equals(tendenId, other.tendenId) && Objects.equals(venderId, other.venderId);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVenderId() {
		return venderId;
	}
	public void setVenderId(String venderId) {
		this.venderId = venderId;
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
