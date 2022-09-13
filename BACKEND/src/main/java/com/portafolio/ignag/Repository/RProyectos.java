package com.portafolio.ignag.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portafolio.ignag.Entity.Proyectos;

@Repository
public interface RProyectos extends JpaRepository<Proyectos, Integer>{
   
    public Optional<Proyectos> findByNombreP(String nombreP);
    public boolean existsByNombreP(String nombreP);
}
