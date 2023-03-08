package com.masai.dto;

import java.util.Objects;

public class AdministratorImpl implements Administrator {

	static final String GREEN ="\u001B[32m";	
	public static final String bold = "\u001b[1m";
	public static final String reset = "\u001B[0m";

    public static final String italic = "\u001b[3m";

    public static final String black = "\u001b[30m";
    public static final String blue = "\u001b[34m";	

private String id;  
private String name;
private String email;
private String city;
private String password;

public AdministratorImpl(String id , String name, String email, String city , String password) {

	this.id = id;
	this.name = name;
	this.email = email;
	this.city = city;
	this.password= password;
}


public AdministratorImpl() {
	super();
}


@Override
public String getId() {
	return id;
}

@Override
public void setId(String id) {
	this.id = id;
}


@Override
public String getName() {
	return name;
}

@Override
public void setName(String name) {

	this.name = name;
}

@Override
public String getEmail() {
	return email;
}


@Override
public void setEmail(String email) {
	this.email = email;
}


@Override
public String getCity() {
	return city;
}


@Override
public void setCity(String city) {
	this.city = city;
}


@Override
public String getPassword() {
	return password;
}


@Override
public void setPassword(String password) {
	this.password = password;
}



@Override
public String toString() {
	return black+"Name : " + name + "\t Email=" + email + "\t City=" + city;
}




@Override
public int hashCode() {
	return Objects.hash(city, email, name);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	AdministratorImpl other = (AdministratorImpl) obj;
	return Objects.equals(city, other.city) && Objects.equals(email, other.email) && Objects.equals(name, other.name);
}




	
	
	
	
	
}
