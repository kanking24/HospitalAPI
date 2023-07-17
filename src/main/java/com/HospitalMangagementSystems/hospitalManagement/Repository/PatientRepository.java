package com.HospitalMangagementSystems.hospitalManagement.Repository;


import com.HospitalMangagementSystems.hospitalManagement.Model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient,Integer> {

    List<Patient> findAll();
}