package com.HospitalMangagementSystems.hospitalManagement.Controller;

import com.HospitalMangagementSystems.hospitalManagement.Model.Patient;
import com.HospitalMangagementSystems.hospitalManagement.Service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/patient")
public class PatientController {


    @Autowired
    private PatientService patientService;
    // Add a new patient

    @PostMapping("/admit")
    public ResponseEntity<?> admitPatient(@RequestBody @Valid Patient patient){
        return new ResponseEntity<>(patientService.admitPatient(patient), HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public List<Patient> getPatients(){
        return this.patientService.getAllPatients();
    }

    @DeleteMapping(value = "/discharge/{id}")
    public void dischargePatients(@PathVariable("id") int id){
        patientService.dischargePatient(id);
    }

}
