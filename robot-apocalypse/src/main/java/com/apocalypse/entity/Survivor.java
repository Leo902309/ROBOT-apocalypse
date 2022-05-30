package com.apocalypse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Survivor.infectedSurvivors",query = "select e from Survivor e where e.isInfacted = true")
@NamedQuery(name="Survivor.nonInfectedSurvivors",query = "select e from Survivor e where e.isInfacted = false")
@NamedQuery(name="Survivor.infectedSurvivorsCount",query = "select count(e) from Survivor e where e.isInfacted = true")

public class Survivor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long primaryKey;
	private String name;
	private int age;
	private String gender;
	@Column(unique = true)
	private String id;
	private String lastLocation; // latitude~longitude
	public boolean isInfacted;
	
	public Survivor() {
		
	}
	public Survivor(String name, int age, String gender, String id, String lastLocation,boolean isInfacted) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.id = id;
		this.lastLocation = lastLocation;
		this.isInfacted=isInfacted;
	}
	public long getPrimaryKey() {
		return primaryKey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLastLocation() {
		return lastLocation;
	}
	public void setLastLocation(String lastLocation) {
		this.lastLocation = lastLocation;
	}
	
	public boolean getIsInfacted() {
		return this.isInfacted;
	}
	public void setIsInfacted(boolean isInfected) {
		this.isInfacted = isInfected;
	}
	
	
	
}
