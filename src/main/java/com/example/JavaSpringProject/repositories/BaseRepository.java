package com.example.JavaSpringProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BaseRepository<T> extends JpaRepository<T,Long> {
    List<T> findByIdIn(List<Long> ids);
}
