package com.portafolio.ignag.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreSkills;
    private int porcentaje; 
    private String imgsrc; 
    private String colorInterno;
    private String colorExterno;


    public Skills() {
    }


    public Skills(int id, String nombreSkills, int porcentaje, String imgsrc, String colorInterno, String colorExterno) {
        this.id = id;
        this.nombreSkills = nombreSkills;
        this.porcentaje = porcentaje;
        this.imgsrc = imgsrc;
        this.colorInterno = colorInterno;
        this.colorExterno = colorExterno;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNombreSkills() {
        return nombreSkills;
    }


    public void setNombreSkill(String nombreSkills) {
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


    public void setNombreSkills(String nombreSkills2) {
    }    

    
    
}


