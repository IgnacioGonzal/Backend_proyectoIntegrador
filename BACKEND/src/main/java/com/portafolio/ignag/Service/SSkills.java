package com.portafolio.ignag.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolio.ignag.Entity.Skills;
import com.portafolio.ignag.Repository.RSkills;

@Service
@Transactional
public class SSkills {
    @Autowired
    RSkills rSkills;

    public List<Skills> list() {
        return rSkills.findAll();
    }

    public Optional<Skills> getOne(int id) {
        return rSkills.findById(id);
    }

    public Optional<Skills> getByNombreSkills(String nombreSkills) {
        return rSkills.findBynombreSkills(nombreSkills);
    }

    
    public void save(Skills skills){
        rSkills.save(skills);
    }
    
    public void delete(int id){
        rSkills.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rSkills.existsById(id);
    }
    
    public boolean existsByNombreSkills(String nombreSkills){
        return rSkills.existsBynombreSkills(nombreSkills);
    }


}
