package com.example.api.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.api.beans.Doctor;
import com.example.api.beans.Patient;
import com.example.api.repository.DoctorRepo;
import com.example.api.repository.PatientRepo;

@Controller
@RequestMapping("/HospitalManagement/doctor")
public class DoctorController {
	@Autowired
	 DoctorRepo doctorrepo;
	@Autowired
	 PatientRepo patientrepo;
	 
	 
	 @PostMapping("/savedoctor")
	 public ModelAndView newPatient(@ModelAttribute("doc") Doctor doctor ) {
		 doctorrepo.save(doctor);
		 return new ModelAndView("doctoradded","doc",doctor);
	 }
	
	 @GetMapping("/registerDoctor")
	 public ModelAndView addDoctor() {
		 Doctor d1=new Doctor();
		return new ModelAndView("newdoctor","doc",d1);	 
	 }
	 @GetMapping("/login")
	 public String loginDoc() {
		 return "doctorlogin";
	 }

	 @GetMapping("/appointments/{name}")
	 public ModelAndView showAppointments(@PathVariable("name") String name) {
		 Doctor d1=doctorrepo.findDoctorByname(name);
		 List<Patient> patients=patientrepo.findPatientByDocid(d1.getId());
		 return new ModelAndView("doctorpatients","patlist",patients);
	 }
	 @GetMapping("/alldoctors")
	 public ModelAndView showAllDoctors() {
		 List<Doctor> doctors=doctorrepo.findAll();
		
		 return new ModelAndView("alldoctors","doctors",doctors);
	 }
	 @GetMapping("/login/correctid")
	 public ModelAndView doctorlogin(@RequestParam(value="doc_name",required=false)String doc_name,@RequestParam(value="doc_field",required=false)String doc_field){
		 Doctor d=doctorrepo.findDoctorBynameAndField(doc_name,doc_field);
		
		if(d==null) {
			return new ModelAndView("incorrectcredentials","nobody",d);
		}
		Set<Patient> patients=d.getPatient();
	  
		 return new ModelAndView("doctorpatients","patlist",patients);
		 
	 }
	 
	 @GetMapping("/deletepat")
		public String deleteDoc(@RequestParam(value="pat_id",required=false)String pat_id){
			int pat=Integer.valueOf(pat_id);
			Patient p=patientrepo.getById(pat);
			p.setDoctor(null);
           patientrepo.save(p);
		return "successdeletion";			
		}
			
}
