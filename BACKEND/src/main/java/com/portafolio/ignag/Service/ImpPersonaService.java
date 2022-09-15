package com.portafolio.ignag.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portafolio.ignag.Entity.Persona;
import com.portafolio.ignag.Interface.IPersonaService;
import com.portafolio.ignag.Repository.IPersonaRepository;;

@Service
public class ImpPersonaService implements IPersonaService{

    @Autowired IPersonaRepository ipersonaRepository;

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);    
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);        
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById((long) 1).orElse(null);
        return persona;
    
}
}
