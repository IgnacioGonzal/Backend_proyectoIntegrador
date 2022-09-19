package com.portafolio.ignag.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import com.portafolio.ignag.Entity.Persona;
import com.portafolio.ignag.Interface.IPersonaService;
import com.portafolio.ignag.Dto.dtoPersona;



@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;


    @GetMapping("/personas/traer")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }

    
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }

  
    @DeleteMapping ("/personas/borrar/{id}")
        public String deletePersona(@PathVariable Long id) {
            ipersonaService.deletePersona(id);
            return "La persona fue eliminada correctamente";
        }

        /*URL:PUERTO/personas/editar/idusuario/nombre & apellido & img */
    
   
    @PutMapping ("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
    @RequestBody dtoPersona personaDto) {
            
            Persona persona = ipersonaService.findPersona(id);

            persona.setNombre(personaDto.getNombre());
            persona.setApellido(personaDto.getApellido());
            persona.setImg(personaDto.getImg());
            persona.setAbout(personaDto.getAbout());


            ipersonaService.savePersona(persona);
            return persona;

                                }

            @GetMapping("/personas/traer/perfil")
            public Persona findPersona() {
                
                return ipersonaService.findPersona((long)1);

            }

}
