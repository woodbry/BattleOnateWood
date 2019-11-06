package com.trms.beans;

public class Employee {
		private String firstName;
		private String lastName;
		private String userName;
		private String password;
		private String location;
		private int empId;
		private double availableFunds;
		private boolean isDepHead;
		private boolean isDirectSup;
		private boolean isBennyCoord;
		
//constructors
	       public Employee() {
	   		super();
	   		// TODO Auto-generated constructor stub
	   	}      
	       
                   
       public Employee(String firstName, String lastName, String userName, String password, String location, int empId,
		boolean isDepHead, boolean isDirectSup, boolean isBennyCoord) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.userName = userName;
	this.password = password;
	this.location = location;
	this.empId = empId;
	this.isDepHead = isDepHead;
	this.isDirectSup = isDirectSup;
	this.isBennyCoord = isBennyCoord;
}


	//getters and setters           
       public String getFirstName() {  
       	return firstName;           
       }                               

	public void setFirstName(String firstName) {
	       	this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public boolean isDepHead() {
			return isDepHead;
		}
		public void setDepHead(boolean isDepHead) {
			this.isDepHead = isDepHead;
		}
		public boolean isDirectSup() {
			return isDirectSup;
		}
		public void setDirectSup(boolean isDirectSup) {
			this.isDirectSup = isDirectSup;
		}
		public boolean isBennyCoord() {
			return isBennyCoord;
		}
		public void setBennyCoord(boolean isBennyCoord) {
			this.isBennyCoord = isBennyCoord;
		}


		
		

		
		


}
