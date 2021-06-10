package com.example.JavaSpringProject.services;

import com.example.JavaSpringProject.exceptions.ResourceNotFoundException;
import com.example.JavaSpringProject.models.Distributor;
import com.example.JavaSpringProject.repositories.DistributorRepository;
import com.example.JavaSpringProject.services.interfaces.IDistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class DistributorService implements IDistributorService {
    DistributorRepository distributorRepository;

    @Autowired
    public DistributorService(DistributorRepository distributorRepository) {
        this.distributorRepository = distributorRepository;
    }

    @Override
    public List<Distributor> findAll() {
        List<Distributor> distributors = new LinkedList<>();
        distributorRepository.findAll().iterator().forEachRemaining(distributors::add);
        return distributors;
    }

    @Override
    public Distributor findById(Long Id) {
        Optional<Distributor> optionalDistributor = distributorRepository.findById(Id);
        if (optionalDistributor.isEmpty()) {
            throw new ResourceNotFoundException("Distributor " + Id + " not found!");
        }
        return optionalDistributor.get();
    }

    @Override
    public Distributor save(Distributor entity) {
        return distributorRepository.save(entity);
    }

    @Override
    public void deleteById(Long Id) {
        Optional<Distributor> optionalDistributor = distributorRepository.findById(Id);
        if (optionalDistributor.isEmpty()) {
            throw new ResourceNotFoundException("Distributor " + Id + " not found!");
        }
        distributorRepository.deleteById(Id);
    }
}
