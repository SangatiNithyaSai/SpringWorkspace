package com.example.api.beans;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Patient {
	@Id
	@Column(name="pat_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
private String name;
private int age;
private String email;
private Long ph_no;
private String place;
private int pincode;
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Long getPh_no() {
	return ph_no;
}
public void setPh_no(Long ph_no) {
	this.ph_no = ph_no;
}
public String getPlace() {
	return place;
}
public void setPlace(String place) {
	this.place = place;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
 @ManyToOne
 @JoinColumn(name="doc_id")
 private Doctor doctor;
 public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Doctor getDoctor() {
	return doctor;
}
public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
}
}
