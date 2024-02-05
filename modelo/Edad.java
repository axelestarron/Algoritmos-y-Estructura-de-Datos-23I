package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Edad implements Serializable{    
    private int dia, mes, anio;

    public Edad(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    
    public int calculaEdad(){
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaNac = LocalDate.of(anio, mes, dia);
        Period calculo = Period.between(fechaNac, fechaHoy);
        return calculo.getYears();
    }
}

