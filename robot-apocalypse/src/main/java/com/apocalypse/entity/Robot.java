package com.apocalypse.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import jdk.jfr.Name;

@Entity
@NamedQuery(name="Robot.getCategoryWisedRobots",query = "select e from Robot e where e.category= :category")
public class Robot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long primaryKey;
	private String model;
	@Column(unique = true)
	private String serialNumber;
	private Date manufacturedDate;
	private String category;
	public Robot() {
		
	}
	public Robot(String model, String serialNumber, Date manufacturedDate, String category) {
		super();
		this.model = model;
		this.serialNumber = serialNumber;
		this.manufacturedDate = manufacturedDate;
		this.category = category;
	}

	public long getPrimaryKey() {
		return primaryKey;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Date getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
