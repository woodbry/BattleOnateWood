package com.trms.beans;

public class Forms {
private int empId;
private int formId;
private String supervisorName;
private String eventName;
private String eventType;
private String gradeReceived;
private double eventCost;
private boolean approvedByDS;
private boolean approvedByDH;
private boolean approvedByBC;

//constructors
public Forms(int empId, int formId, boolean approvedByDS, boolean approvedByDH, boolean approvedByBC) {
	super();
	this.empId = empId;
	this.formId = formId;
	this.approvedByDS = approvedByDS;
	this.approvedByDH = approvedByDH;
	this.approvedByBC = approvedByBC;
}


public Forms(int empId, int formId) {
	super();
	this.empId = empId;
	this.formId = formId;
	this.approvedByDS = false;
	this.approvedByDH = false;
	this.approvedByBC = false;
}


public Forms() {
	super();
	// TODO Auto-generated constructor stub
}

//getters and setters

public int getEmpId() {
	return empId;
}

public void setEmpId(int empId) {
	this.empId = empId;
}

public int getFormId() {
	return formId;
}

public void setFormId(int formId) {
	this.formId = formId;
}

public boolean isApprovedByDS() {
	return approvedByDS;
}

public void setApprovedByDS(boolean approvedByDS) {
	this.approvedByDS = approvedByDS;
}

public boolean isApprovedByDH() {
	return approvedByDH;
}

public void setApprovedByDH(boolean approvedByDH) {
	this.approvedByDH = approvedByDH;
}

public boolean isApprovedByBC() {
	return approvedByBC;
}

public void setApprovedByBC(boolean approvedByBC) {
	this.approvedByBC = approvedByBC;
}
 




}