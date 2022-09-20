package com.portafolio.ignag.Controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portafolio.ignag.Dto.dtoSkills;
import com.portafolio.ignag.Entity.Skills;
import com.portafolio.ignag.Security.Controller.Mensaje;
import com.portafolio.ignag.Service.SSkills;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "https://frontendignag.web.app")

public class CSkills {
    @Autowired
    SSkills sSkills;

    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list= sSkills.list();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills){      
        if(StringUtils.isBlank(dtoskills.getNombreSkills()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sSkills.existsByNombreSkills(dtoskills.getNombreSkills()))
            return new ResponseEntity<>(new Mensaje("Este skill existe"), HttpStatus.BAD_REQUEST);

            
        Skills skills = new Skills(0, dtoskills.getNombreSkills(), dtoskills.getPorcentaje(), dtoskills.getImgsrc(), dtoskills.getColorInterno(),dtoskills.getColorExterno());
        sSkills.save(skills);
        
        return new ResponseEntity<>(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        if(!sSkills.existsById(id))
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skills skills = sSkills.getOne(id).get();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskills){
        //Primero Validamos si existe el ID
        if(!sSkills.existsById(id))
            return new ResponseEntity<>(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //luego si es que existe, si el nombre de ese proyecto ya existe, Compara nombre de proyectos
        if(sSkills.existsByNombreSkills(dtoskills.getNombreSkills()) && sSkills.getByNombreSkills(dtoskills.getNombreSkills()).get().getId() != id)
            return new ResponseEntity<>(new Mensaje("Ese skill ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoskills.getNombreSkills()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        //SI pasa las validaciones anteriores, recien ahi va a hacer el update
        Skills skills = sSkills.getOne(id).get();
        skills.setNombreSkills(dtoskills.getNombreSkills());
        skills.setPorcentaje((dtoskills.getPorcentaje()));
        skills.setImgsrc((dtoskills.getImgsrc()));
        skills.setColorInterno((dtoskills.getColorInterno()));
        skills.setColorExterno((dtoskills.getColorExterno()));


        sSkills.save(skills);
        return new ResponseEntity<>(new Mensaje("proyecto actualizado"), HttpStatus.OK);
    }

    //done
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Primero Validamos si existe el ID
        if (!sSkills.existsById(id)) {
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sSkills.delete(id);
        return new ResponseEntity<>(new Mensaje("skill eliminada"), HttpStatus.OK);
    }


    
}
