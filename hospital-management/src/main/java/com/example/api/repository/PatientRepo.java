package com.example.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.api.beans.Patient;

public interface PatientRepo extends  JpaRepository<Patient, Integer>{

	
	@Query(
			 value = "SELECT * FROM Patient p WHERE p.doc_id = ?1", 
			  nativeQuery = true)
			List<Patient> findPatientByDocid(Integer docid);
	

	@Query(
			 value = "SELECT * FROM Patient p WHERE p.name = ?1 AND p.place=?2", 
			  nativeQuery = true)
			Patient findPatientByNameAndPlace(String name,String place);
}
