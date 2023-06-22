package com.simple.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.crud.models.Human;

public interface HumanRepository extends JpaRepository<Human, Integer> {
    Human findById(Long id);

}
