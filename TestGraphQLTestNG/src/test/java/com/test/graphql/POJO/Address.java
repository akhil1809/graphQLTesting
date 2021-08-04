package com.test.graphql.POJO;

public class Address {

    private String street;
    //private double geo;

    
    public Address(String street) {
		super();
		this.street = street;
		//this.geo = d;
	}

	public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

	/*
	 * public double getGeo() { return geo; }
	 * 
	 * public void setGeo(double geo) { this.geo = geo; }
	 */

	/*
	 * @Override public String toString() { return "Address{" + "street='" + street
	 * + '\'' + ", geo=" + geo + '}'; }
	 */
}
