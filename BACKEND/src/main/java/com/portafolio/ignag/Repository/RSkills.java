package com.portafolio.ignag.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portafolio.ignag.Entity.Skills;

@Repository
public interface RSkills extends JpaRepository<Skills, Integer> {
     
    public Optional<Skills> findBynombreSkills(String nombreSkills);
    public boolean existsBynombreSkills(String nombreSkills);
    
}


