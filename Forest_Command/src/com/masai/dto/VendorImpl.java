package com.masai.dto;

import java.util.Objects;



public class VendorImpl implements Vendor {

	static final String GREEN ="\u001B[32m";	
	public static final String bold = "\u001b[1m";
	public static final String reset = "\u001B[0m";
    public static final String italic = "\u001b[3m";
    public static final String black = "\u001b[30m";
    public static final String bgBrightWhite = "\u001b[47;1m";
    public static final String blue = "\u001b[34m";	
    public static final String underline = "\u001b[4m";
private String id;
private String password;
private String name;
private String email;
private String number;
private String city;




public VendorImpl() {
	super();
}
public VendorImpl(String id, String password, String name, String email, String number, String city) {
	super();
	this.id = id;
	this.password = password;
	this.name = name;
	this.email = email;
	this.number=number;
	this.city = city;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}

@Override
public String toString() {
	return reset+bgBrightWhite+bold+black+"\t\t" + id + "\t\t" + password + "\t\t" + name+"\t\t";
}
@Override
public int hashCode() {
	return Objects.hash(city, email, id, name, password);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	VendorImpl other = (VendorImpl) obj;
	return Objects.equals(city, other.city) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
			&& Objects.equals(name, other.name) && Objects.equals(password, other.password);
}





}
