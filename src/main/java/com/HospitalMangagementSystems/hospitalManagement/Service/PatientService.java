package com.HospitalMangagementSystems.hospitalManagement.Service;

import com.HospitalMangagementSystems.hospitalManagement.Model.Patient;
import com.HospitalMangagementSystems.hospitalManagement.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository repository;

    public Patient admitPatient(Patient patient) {
        repository.save(patient);
        return patient;
    }

    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    public void dischargePatient(int id){
        repository.deleteById(id);
    }

}
