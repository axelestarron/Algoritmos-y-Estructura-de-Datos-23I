package modelo;

import java.io.Serializable;

public class DatosLabo implements Serializable{
    private String puesto, instit, ciudad, pais;
    private int mesInicio, anioInicio, mesFin, anioFin;

    public DatosLabo(String instit, String puesto, int mesInicio, int anioInicio, int mesFin, int anioFin, String ciudad, String pais) {
        this.puesto = puesto;
        this.instit = instit;
        this.ciudad = ciudad;
        this.pais = pais;
        this.mesInicio = mesInicio;
        this.anioInicio = anioInicio;
        this.mesFin = mesFin;
        this.anioFin = anioFin;
    }  

    public String getPuesto() {
        return puesto;
    }

    public String getInstit() {
        return instit;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public int getMesInicio() {
        return mesInicio;
    }

    public int getAnioInicio() {
        return anioInicio;
    }

    public int getMesFin() {
        return mesFin;
    }

    public int getAnioFin() {
        return anioFin;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setInstit(String instit) {
        this.instit = instit;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setMesInicio(int mesInicio) {
        this.mesInicio = mesInicio;
    }

    public void setAnioInicio(int anioInicio) {
        this.anioInicio = anioInicio;
    }

    public void setMesFin(int mesFin) {
        this.mesFin = mesFin;
    }

    public void setAnioFin(int anioFin) {
        this.anioFin = anioFin;
    }
    
    
}
