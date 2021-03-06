package com.example.api.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Doctor {
@Id
@Column(name="doc_id")
@GeneratedValue(strategy=GenerationType.AUTO)
 private int id;

private String name;
@OneToMany(mappedBy="doctor")
 private Set<Patient> patients;

private int age;
private String field;
private int exp_in_years;

public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getField() {
	return field;
}
public void setField(String field) {
	this.field = field;
}
public int getExp_in_years() {
	return exp_in_years;
}
public void setExp_in_years(int exp_in_years) {
	this.exp_in_years = exp_in_years;
}
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
public Set<Patient> getPatient() {
	return patients;
}
public void setPatient(Set<Patient> patients) {
	this.patients = patients;
}
 
 
}
