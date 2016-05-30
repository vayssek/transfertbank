package org.formation.transfertbank;

public class Customer {
	
	private String lastName;
	private String firstName;
	private String completeName;
	
	public Customer(String firstName, String lastName){
		this.firstName=firstName;
		this.lastName=lastName;
		this.completeName=firstName+"_"+lastName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getCompleteName() {
		return completeName;
	}
	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

}
