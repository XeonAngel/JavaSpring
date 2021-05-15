package com.example.JavaSpringProject.controllers;

import com.example.JavaSpringProject.services.*;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController<T> implements IBaseController<T> {
    protected SpecializationService specializationService;
    protected DepartmentService departmentService;
    protected PatientService patientService;
    protected ConsultationService consultationService;
    protected DistributorService distributorService;
    protected DrugService drugService;
    protected OccupationService occupationService;
    protected StaffService staffService;

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Autowired
    public void setSpecializationService(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @Autowired
    public void setConsultationService(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @Autowired
    public void setDistributorService(DistributorService distributorService) {
        this.distributorService = distributorService;
    }

    @Autowired
    public void setDrugService(DrugService drugService) {
        this.drugService = drugService;
    }

    @Autowired
    public void setOccupationService(OccupationService occupationService) {
        this.occupationService = occupationService;
    }

    @Autowired
    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }
}