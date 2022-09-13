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

import com.portafolio.ignag.Dto.dtoProyectos;
import com.portafolio.ignag.Entity.Proyectos;
import com.portafolio.ignag.Security.Controller.Mensaje;
import com.portafolio.ignag.Service.SProyectos;

@RestController
@RequestMapping("proyect")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyectos {
    @Autowired
    SProyectos sProyectos;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list= sProyectos.list();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyect){      
        if(StringUtils.isBlank(dtoproyect.getNombreP()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sProyectos.existsByNombreP(dtoproyect.getNombreP()))
            return new ResponseEntity<>(new Mensaje("Este proyecto existe"), HttpStatus.BAD_REQUEST);

            
        Proyectos proyectos = new Proyectos(0, dtoproyect.getNombreP(), dtoproyect.getDescripcionP(), dtoproyect.getImgP());
        sProyectos.save(proyectos);
        
        return new ResponseEntity<>(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyect){
        //Primero Validamos si existe el ID
        if(!sProyectos.existsById(id))
            return new ResponseEntity<>(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //luego si es que existe, si el nombre de ese proyecto ya existe, Compara nombre de proyectos
        if(sProyectos.existsByNombreP(dtoproyect.getNombreP()) && sProyectos.getByNombreP(dtoproyect.getNombreP()).get().getId() != id)
            return new ResponseEntity<>(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoproyect.getNombreP()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        //SI pasa las validaciones anteriores, recien ahi va a hacer el update
        Proyectos proyectos = sProyectos.getOne(id).get();
        proyectos.setNombreP(dtoproyect.getNombreP());
        proyectos.setDescripcionP((dtoproyect.getDescripcionP()));
        proyectos.setImgP((dtoproyect.getImgP()));

        sProyectos.save(proyectos);
        return new ResponseEntity<>(new Mensaje("proyecto actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Primero Validamos si existe el ID
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sProyectos.delete(id);
        return new ResponseEntity<>(new Mensaje("proyecto eliminado"), HttpStatus.OK);
    }










}


