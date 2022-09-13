package com.portafolio.ignag.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreP;
    private String descripcionP;
    private String imgP;


    public Proyectos() {
    }


    public Proyectos(int id, String nombreP, String descripcionP, String imgP) {
        this.id = id;
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.imgP = imgP;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
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