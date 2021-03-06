package com.example.api.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.api.beans.Doctor;
import com.example.api.beans.Idmapping;
import com.example.api.beans.Patient;
import com.example.api.repository.DoctorRepo;
import com.example.api.repository.PatientRepo;

@Controller
@RequestMapping("/HospitalManagement/")
public class HospitalController {
	
	@Autowired
	 DoctorRepo doctorrepo;
	@Autowired
	 PatientRepo patientrepo;
	
	@GetMapping("/")
	public String getHome() {
		return "home";
	}
	@GetMapping("/admin")
	public String adminLogin() {
		return "adminlogin";
	}
	
	@GetMapping("/adminoperation")
	public String adminOperations(){
		return "adminoperation";
	}
	@GetMapping("/admin/fixappointment")
	public ModelAndView fixappointment() {
      Idmapping idmaps=new Idmapping();
	return new ModelAndView("mappingform","ids",idmaps);
	}
	@PostMapping("/admin/saveappointment")
	public ModelAndView saveAppointment(@ModelAttribute("ids")Idmapping ids) {
		Patient p=patientrepo.findById(ids.getPat_id()).get();
		if(p.getDoctor()==null) {
		Doctor doctor=doctorrepo.findById(ids.getDoc_id()).get();
		doctor.getPatient().add(p);
		p.setDoctor(doctor);
		patientrepo.save(p);}
		else {
			return new ModelAndView("appointmentfailure","pat",p);
		}
		return new ModelAndView("appointmentsuccess","pat",p);
	}
	
	@GetMapping("/admin/deletedoc")
	public ModelAndView deleteDoc(@RequestParam(value="doc_id",required=false)String doc_id){
		int doc=Integer.valueOf(doc_id);
		Doctor d=doctorrepo.getById(doc);
		Set<Patient> patients=d.getPatient();
		for(Patient p:patients) {
			p.setDoctor(null);
			patientrepo.save(p);
		}
		  
		doctorrepo.deleteById(doc);
         System.out.println("deleted");
		 List<Doctor> doctors=doctorrepo.findAll();
		 
		
	return new ModelAndView("alldoctors","doctors",doctors);
	}
}
