package com.portafolio.ignag.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProyectos {
    @NotBlank
    private String nombreP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String imgP;


    public dtoProyectos() {
    }


    public dtoProyectos(@NotBlank String nombreP, @NotBlank String descripcionP, @NotBlank String imgP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.imgP = imgP;
    }


    public String getNombreP() {
        return nombreP;
    }


    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }


    public String getDescripcionP() {
        return descripcionP;
    }


    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }


    public String getImgP() {
        return imgP;
    }


    public void setImgP(String imgP) {
        this.imgP = imgP;
    }

}
