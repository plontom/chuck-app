package com.tp.repository;

import com.tp.repository.entity.JokesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokesJpaRepository extends JpaRepository<JokesEntity, Integer> {
}
