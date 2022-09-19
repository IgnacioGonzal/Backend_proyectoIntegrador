package com.portafolio.ignag.Dto;

import javax.validation.constraints.NotBlank;

public class dtoPersona{
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String about;
    @NotBlank
    private String img;

    public dtoPersona() {
    }

    public dtoPersona(@NotBlank String nombre, @NotBlank String apellido, @NotBlank String about,
            @NotBlank String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.about = about;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    

    

}


   
