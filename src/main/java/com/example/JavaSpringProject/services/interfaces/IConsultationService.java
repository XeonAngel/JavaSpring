package com.example.JavaSpringProject.services.interfaces;

import com.example.JavaSpringProject.models.Consultation;
import org.springframework.data.domain.Page;

public interface IConsultationService extends BaseService<Consultation> {
    Page<Consultation> findPaginated(int pageNo, int pageSize, String orderBy, String order);
}
