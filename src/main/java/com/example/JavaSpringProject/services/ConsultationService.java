package com.example.JavaSpringProject.services;

import com.example.JavaSpringProject.exceptions.ResourceNotFoundException;
import com.example.JavaSpringProject.models.Consultation;
import com.example.JavaSpringProject.repositories.ConsultationRepository;
import com.example.JavaSpringProject.services.interfaces.IConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService implements IConsultationService {
    ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    @Override
    public List<Consultation> findAll() {
        List<Consultation> consultations = new LinkedList<>();
        consultationRepository.findAll().iterator().forEachRemaining(consultations::add);
        return consultations;
    }

    @Override
    public Consultation findById(Long Id) {
        Optional<Consultation> optionalConsultation = consultationRepository.findById(Id);
        if (optionalConsultation.isEmpty()) {
            throw new ResourceNotFoundException("Consultation " + Id + " not found!");
        }
        return optionalConsultation.get();
    }

    @Override
    public Consultation save(Consultation entity) {
        return consultationRepository.save(entity);
    }

    @Override
    public void deleteById(Long Id) {
        Optional<Consultation> optionalConsultation = consultationRepository.findById(Id);
        if (optionalConsultation.isEmpty()) {
            throw new ResourceNotFoundException("Consultation " + Id + " not found!");
        }
        consultationRepository.deleteById(Id);
    }

    public List<Consultation> findAllAtPage(Pageable pageable){
        return consultationRepository.findAll(pageable).toList();
    }
}
