package br.com.linkup.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Location {
	
	@JacksonXmlProperty(namespace="city")
	private String city;
	@JacksonXmlProperty(namespace="state")
	private String state;
	@JacksonXmlProperty(namespace="country")
	private String country;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
