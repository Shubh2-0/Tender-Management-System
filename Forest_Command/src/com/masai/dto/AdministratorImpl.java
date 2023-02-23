package com.masai.dto;

import java.util.Objects;

public class AdministratorImpl implements Administrator {

private String name;
private String email;
private String city;
public AdministratorImpl(String name, String email, String city) {
	super();
	this.name = name;
	this.email = email;
	this.city = city;
}
public AdministratorImpl() {
	super();
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
@Override
public String toString() {
	return "AdministratorImpl [name=" + name + ", email=" + email + ", city=" + city + "]";
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
