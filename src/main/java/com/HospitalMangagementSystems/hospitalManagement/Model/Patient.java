package com.HospitalMangagementSystems.hospitalManagement.Model;

import jakarta.persistence.*;

@Entity
public class Patient {

    // Assumption 1 added patientId for uniquely identifying the patient

    @Id
    @Column(name = "Patient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @Column(name = "Patient_name")
    private String name;
    private int age;
    private int room;

    // Would have OneToManyMapping

//    @ManyToOne
    private String DocterName;
    private int admitDate;
    private int expenses;

//    @Enumerated(EnumType.STRING)
    private status status;

    public Patient() {
    }

    public Patient(Long patientId, String name, int age, int room, String docterName, int admitDate, int expenses, com.HospitalMangagementSystems.hospitalManagement.Model.status status) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.room = room;
        DocterName = docterName;
        this.admitDate = admitDate;
        this.expenses = expenses;
        this.status = status;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getDocterName() {
        return DocterName;
    }

    public void setDocterName(String docterName) {
        DocterName = docterName;
    }

    public int getAdmitDate() {
        return admitDate;
    }

    public void setAdmitDate(int admitDate) {
        this.admitDate = admitDate;
    }

    public int getExpenses() {
        return expenses;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }

    public com.HospitalMangagementSystems.hospitalManagement.Model.status getStatus() {
        return status;
    }

    public void setStatus(com.HospitalMangagementSystems.hospitalManagement.Model.status status) {
        this.status = status;
    }
}

enum status {
    ADMITTED,
    DISCHARGED
}