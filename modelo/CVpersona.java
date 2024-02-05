package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class CVpersona implements Serializable{
    private DatosGrales grales;
    private ArrayList<DatosAcad> acad;
    private ArrayList<DatosLabo> labo;
    private ArrayList<Habilidades> habi;
    private ArrayList<Idiomas> idiom;
    private String userName;

    public CVpersona(DatosGrales x, DatosAcad a, DatosLabo b, Habilidades c, Idiomas d) {
        this.grales = grales;
        this.acad.add(a);
        this.labo.add(b);
        this.habi.add(c);
        this.idiom.add(d);
        this.userName = grales.getNombre() + grales.getApPat() + grales.getApMat();
    }
    
    public void addAca(DatosAcad a1){
        this.acad.add(a1);
    }
    
    public void addLabo(DatosLabo b1){
        this.labo.add(b1);
    }
    
    public void addHab(Habilidades c1){
        this.habi.add(c1);
    }
    
    public void addIdi(Idiomas d1){
        this.idiom.add(d1);
    }
    
    public void deleteAca(int deleteIndex){
        this.acad.remove(deleteIndex);
    }
    
    public void deleteLabo(int deleteIndex){
        this.labo.remove(deleteIndex);
    }
    
    public void deleteHab(int deleteIndex){
        this.habi.remove(deleteIndex);
    }
    
    public void deleteIdi(int deleteIndex){
        this.idiom.remove(deleteIndex);
    }
    
    public void modifyAca(int modIndex, DatosAcad modDatos){
        this.acad.set(modIndex,modDatos);
    }
    
    public void modifyLabo(int modIndex, DatosLabo modDatos){
        this.labo.set(modIndex,modDatos);
    }
    
    public void modifyHab(int modIndex, Habilidades modDatos){
        this.habi.set(modIndex,modDatos);
    }
    
    public void modifyIdi(int modIndex, Idiomas modDatos){
        this.idiom.set(modIndex,modDatos);
    }
    
}
