package modelo;

import java.io.Serializable;

public class Idiomas implements Serializable{
    private String idioma, nivel;

    public Idiomas(String idioma, String nivel) {
        this.idioma = idioma;
        this.nivel = nivel;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getNivel() {
        return nivel;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    
}
