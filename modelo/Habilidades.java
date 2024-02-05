package modelo;

import java.io.Serializable;

public class Habilidades implements Serializable{
    private String tipo, desc, nivel;

    public Habilidades(String tipo, String desc, String nivel) {
        this.tipo = tipo;
        this.desc = desc;
        this.nivel = nivel;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDesc() {
        return desc;
    }

    public String getNivel() {
        return nivel;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    
}
