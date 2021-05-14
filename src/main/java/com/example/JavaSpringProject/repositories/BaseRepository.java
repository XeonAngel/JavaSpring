package com.example.JavaSpringProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T,Long> {
    List<T> findByIdIn(List<Long> ids);
}
