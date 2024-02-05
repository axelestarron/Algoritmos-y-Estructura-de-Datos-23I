package modelo;

import java.io.Serializable;
import java.text.Normalizer;

public class DatosGrales implements Serializable{
    private String nombre, apPat, apMat, rfc, ciudad, pais;
    private int dia, mes, anio, edad;
    private Edad edadProv;
    private Rfc rfcProv;
    
    public DatosGrales(String nombre, String apPat, String apMat, int dia, int mes, int anio, String ciudad, String pais) {
        this.nombre = nombre;
        this.apPat = apPat;
        this.apMat = apMat;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.ciudad = ciudad;
        this.pais = pais;
        edadProv = new Edad(dia, mes, anio);
        this.edad = edadProv.calculaEdad();
        if (esMexico(pais)) {
            rfcProv = new Rfc(nombre, apPat, apMat, dia, mes, anio);
            this.rfc = rfcProv.calculaRfc();
        } else {
            this.rfc = "----------";
        }
    }
    
    private boolean esMexico(String pais){
        String inputNorm = omiteCaracteres(pais);
        String targetNorm = omiteCaracteres("Mexico");
        return inputNorm.equalsIgnoreCase(targetNorm);
    }
    
    private String omiteCaracteres(String input){
        return Normalizer.normalize(input, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
    }

    public String getNombre() {
        return nombre;
    }

    public String getApPat() {
        return apPat;
    }

    public String getApMat() {
        return apMat;
    }

    public String getRfc() {
        return rfc;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApPat(String apPat) {
        this.apPat = apPat;
    }

    public void setApMat(String apMat) {
        this.apMat = apMat;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
