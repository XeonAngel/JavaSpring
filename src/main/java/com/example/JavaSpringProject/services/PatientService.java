package com.example.JavaSpringProject.services;

import com.example.JavaSpringProject.models.Patient;
import com.example.JavaSpringProject.repositories.PatientRepository;
import com.example.JavaSpringProject.services.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {
    PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patients = new LinkedList<>();
        patientRepository.findAll().iterator().forEachRemaining(patients::add);
        return patients;
    }

    @Override
    public Patient findById(Long Id) {
        Optional<Patient> optionalPatient = patientRepository.findById(Id);
        if (optionalPatient.isEmpty()) {
            throw new RuntimeException("Patient not found!");
        }
        return optionalPatient.get();
    }

    @Override
    public Patient save(Patient entity) {
        return patientRepository.save(entity);
    }

    @Override
    public void deleteById(Long Id) {
        patientRepository.deleteById(Id);
    }
}
