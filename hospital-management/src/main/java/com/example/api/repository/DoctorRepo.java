package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.api.beans.Doctor;

public interface DoctorRepo  extends JpaRepository<Doctor,Integer> {
	
	@Query(
			  value = "SELECT * FROM Doctor d WHERE d.name = ?1", 
			  nativeQuery = true)
	Doctor findDoctorByname(String name);
	

	@Query(
			  value = "SELECT * FROM Doctor d WHERE d.name = ?1 AND d.field=?2", 
			  nativeQuery = true)
	Doctor findDoctorBynameAndField(String name,String Field);

}
