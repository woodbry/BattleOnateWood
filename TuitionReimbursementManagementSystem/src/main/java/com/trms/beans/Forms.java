package com.trms.beans;

import java.util.Date;

public class Forms {

	private int formId;
	private int empId;
	private String supervisorName;
	private String eventName;
	private String eventType;
	private double eventCost;
	private boolean approvedByDS;
	private boolean approvedByDH;
	private boolean approvedByBC;
	private Date dateCompleted;
	
	
public Forms(int formId, int empId, String supervisorName, String eventName, String eventType, double eventCost,
			boolean approvedByDS, boolean approvedByDH, boolean approvedByBC, Date dateCompleted) {
		super();
		this.formId = formId;
		this.empId = empId;
		this.supervisorName = supervisorName;
		this.eventName = eventName;
		this.eventType = eventType;
		this.eventCost = eventCost;
		this.approvedByDS = approvedByDS;
		this.approvedByDH = approvedByDH;
		this.approvedByBC = approvedByBC;
		this.dateCompleted = dateCompleted;
	}


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


public String getSupervisorName() {
	return supervisorName;
}


public void setSupervisorName(String supervisorName) {
	this.supervisorName = supervisorName;
}


public String getEventName() {
	return eventName;
}


public void setEventName(String eventName) {
	this.eventName = eventName;
}


public String getEventType() {
	return eventType;
}


public void setEventType(String eventType) {
	this.eventType = eventType;
}


public double getEventCost() {
	return eventCost;
}


public void setEventCost(double eventCost) {
	this.eventCost = eventCost;
}


public Date getDateCompleted() {
	return dateCompleted;
}


public void setDateCompleted(Date dateCompleted) {
	this.dateCompleted = dateCompleted;
}


@Override
public String toString() {
	return "Forms [formId=" + formId + ", empId=" + empId + ", supervisorName=" + supervisorName + ", eventName="
			+ eventName + ", eventType=" + eventType + ", eventCost=" + eventCost + ", approvedByDS=" + approvedByDS
			+ ", approvedByDH=" + approvedByDH + ", approvedByBC=" + approvedByBC + ", dateCompleted=" + dateCompleted
			+ "]";
}
 




}