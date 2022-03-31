package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.api.beans.Doctor;
import com.example.api.beans.Patient;
import com.example.api.repository.PatientRepo;

@Controller
@RequestMapping("/HospitalManagement/patient")
public class PatientController {
 

	 @Autowired
	 PatientRepo patientrepo;
	 
	 
	 @PostMapping("/savepatient")
	 public ModelAndView newPatient(@ModelAttribute("pat") Patient patient) {
		 patientrepo.save(patient);
		 return new ModelAndView("appointmentsuccess","pat",patient);
	 }
	
	 @GetMapping("/registerPatient")
	 public ModelAndView addPatient() {
		 Patient p1=new Patient();
		return new ModelAndView("newpatient","pat",p1);	 
	 }

	 @GetMapping("/allpatients")
	 public ModelAndView showAllDoctors() {
		 List<Patient> patients=patientrepo.findAll();
		 return new ModelAndView("allpatients","patients",patients);
	 }
}
