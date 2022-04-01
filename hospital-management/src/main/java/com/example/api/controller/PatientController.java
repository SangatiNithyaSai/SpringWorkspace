package com.example.api.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.api.beans.Doctor;
import com.example.api.beans.Patient;
import com.example.api.repository.DoctorRepo;
import com.example.api.repository.PatientRepo;

@Controller
@RequestMapping("/HospitalManagement/patient")
public class PatientController {
 

	 @Autowired
	 PatientRepo patientrepo;
	 @Autowired
	 DoctorRepo doctorrepo;
	 
	 @PostMapping("/savepatient")
	 public ModelAndView newPatient(@ModelAttribute("pat") Patient patient) {
		 patientrepo.save(patient);
		 return new ModelAndView("appointmentsuccess","pat",patient);
	 }
	 @GetMapping("/login")
	 public String loginDoc() {
		 return "patientlogin";
	 }

	 @GetMapping("/login/correctid")
	 public ModelAndView doctorlogin(@RequestParam(value="pat_name",required=false)String pat_name,@RequestParam(value="pat_place",required=false)String pat_place){
		 Patient p=patientrepo.findPatientByNameAndPlace(pat_name,pat_place);
		if(p==null) {
			return new ModelAndView("incorrectcredentials","nobody",p);
		}
	     Doctor d=p.getDoctor();
	     if(d==null) {
	    	 return new ModelAndView("nodoctor","pat",p);
	     }
		 return new ModelAndView("patientdetails","doctor",d);
		 
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
