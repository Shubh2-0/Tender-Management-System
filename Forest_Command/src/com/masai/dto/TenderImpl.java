package com.masai.dto;

import java.util.Objects;

public class TenderImpl implements Tender {

	private String id;
	private String name;
	private String type;
	private int price;
	private String city;
	
	
	public TenderImpl() {
		super();
	}


	public TenderImpl(String id, String name, String type, int price, String city) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.city = city;
	}


	@Override
	public String toString() {
		return "Tender [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", city=" + city + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(city, id, name, price, type);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TenderImpl other = (TenderImpl) obj;
		return Objects.equals(city, other.city) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& price == other.price && Objects.equals(type, other.type);
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
	
	
	
}
