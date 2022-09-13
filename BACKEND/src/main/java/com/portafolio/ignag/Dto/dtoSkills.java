package com.portafolio.ignag.Dto;

import javax.validation.constraints.NotBlank;

public class dtoSkills {
    @NotBlank
    private String nombreSkills;
    @NotBlank
    private int porcentaje;
    @NotBlank 
    private String imgsrc;
    @NotBlank 
    private String colorInterno;
    @NotBlank
    private String colorExterno;


    public dtoSkills() {
    }


    public dtoSkills(@NotBlank String nombreSkills, @NotBlank int porcentaje, @NotBlank String imgsrc,
            @NotBlank String colorInterno, @NotBlank String colorExterno) {
        this.nombreSkills = nombreSkills;
        this.porcentaje = porcentaje;
        this.imgsrc = imgsrc;
        this.colorInterno = colorInterno;
        this.colorExterno = colorExterno;
    }


    public String getNombreSkills() {
        return nombreSkills;
    }


    public void setNombreSkills(String nombreSkills) {
        this.nombreSkills = nombreSkills;
    }


    public int getPorcentaje() {
        return porcentaje;
    }


    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }


    public String getImgsrc() {
        return imgsrc;
    }


    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }


    public String getColorInterno() {
        return colorInterno;
    }


    public void setColorInterno(String colorInterno) {
        this.colorInterno = colorInterno;
    }


    public String getColorExterno() {
        return colorExterno;
    }


    public void setColorExterno(String colorExterno) {
        this.colorExterno = colorExterno;
    }

    

    
    
    
}
