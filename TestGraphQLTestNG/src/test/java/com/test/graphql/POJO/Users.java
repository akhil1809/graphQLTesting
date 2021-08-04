package com.test.graphql.POJO;

import java.util.List;
import java.util.Map;

public class Users {

    private String name;
    private float age;
    private List<Contacts> contact;
    private Enum gender;
    private List<Address> addresses;
    private int limit;
    private Map<String, Object> record;

    public Map<String, Object> getRecord() {
		return record;
	}


	public void setRecord(Map<String, Object> hm) {
		this.record = hm;
	}


	public int getLimit() {
        return limit;
    }


    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public List<Contacts> getContact() {
        return contact;
    }

    public void setContact(List<Contacts> contact) {
        this.contact = contact;
    }

    public Enum getGender() {
        return gender;
    }

    public void setGender(Enum gender) {
        this.gender = gender;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

	/*
	 * @Override public String toString() { return "Users{" + "name='" + name + '\''
	 * + ", age=" + age + ", contact=" + contact + ", gender=" + gender +
	 * ", addresses=" + addresses + ", limit=" + limit + '}'; }
	 */
}
