package modelo;

import java.io.Serializable;

public class Rfc implements Serializable{
    private String nombre, apPat, apMat;
    private int dia, mes, anio;

    public Rfc(String nombre, String apPat, String apMat, int dia, int mes, int anio) {
        this.nombre = nombre;
        this.apPat = apPat;
        this.apMat = apMat;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    
    public String calculaRfc(){
        String rfcPat1 = apPat.substring(0, 1);
        String rfcPat2 = getVocal(apPat.substring(1));
        String rfcMat = apMat.substring(0, 1);
        String rfcNom = nombre.substring(0, 1);
        String rfcAnio = String.valueOf(anio).substring(2);
        String rfcMes = String.format("%02d", mes);
        String rfcDia = String.format("%02d", dia);
        String rfc = rfcPat1 + rfcPat2 + rfcMat + rfcNom + rfcAnio + rfcMes + rfcDia;
        return rfc.toUpperCase();
    }
    
    public String getVocal(String input){
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (esVocal(currentChar)) {
                return String.valueOf(currentChar);
            }
        }
        return "X";
    }
    
    public boolean esVocal(char c){
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}

