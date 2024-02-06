package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class CVpersona implements Serializable{
    private DatosGrales grales;
    private ArrayList<DatosAcad> acad=new ArrayList<DatosAcad>();
    private ArrayList<DatosLabo> labo=new ArrayList<DatosLabo>();
    private ArrayList<Habilidades> habi=new ArrayList<Habilidades>();
    private ArrayList<Idiomas> idiom=new ArrayList<Idiomas>();
    private String userName;

    public CVpersona(DatosGrales x, DatosAcad a, DatosLabo b, Habilidades c, Idiomas d) {
        this.grales = x;
        this.acad.add(a);
        this.labo.add(b);
        this.habi.add(c);
        this.idiom.add(d);
        this.userName = grales.getNombre() + grales.getApPat() + grales.getApMat();
    }

    public CVpersona(DatosGrales x, ArrayList<DatosAcad> a, ArrayList<DatosLabo> b, ArrayList<Habilidades> c, ArrayList<Idiomas> d) {
        this.grales = x;
        this.acad=a;
        this.labo=b;
        this.habi=c;
        this.idiom=d;
        this.userName = grales.getNombre() + grales.getApPat() + grales.getApMat();
    }

    public void recalUsername(){
        this.userName= grales.getNombre() + grales.getApPat() + grales.getApMat();
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
    
    public String getUsername(){
        return this.userName;
    }

    public DatosGrales getDatosGrales(){
        return this.grales;
    }

    public void setDatosGrales(DatosGrales nuevosDatosGrales){
        this.grales=nuevosDatosGrales;
        this.recalUsername();
    }

    public ArrayList<DatosAcad> getDatosAcad(){
        return this.acad;
    }

    public void setDatosAcad(ArrayList<DatosAcad> nuevosDatosAcad){
        this.acad=nuevosDatosAcad;
    }


    public ArrayList<DatosLabo> getDatosLabo(){
        return this.labo;
    }

    public void setDatosLabo(ArrayList<DatosLabo> nuevosDatosLabo){
        this.labo=nuevosDatosLabo;
    }

    public ArrayList<Habilidades> getHabi(){
        return this.habi;
    }

    public void setHabi(ArrayList<Habilidades> nuevasHabi){
        this.habi=nuevasHabi;
    }

    public ArrayList<Idiomas> getIdiomas(){
        return this.idiom;
    }

    public void setIdiomas(ArrayList<Idiomas> nuevosIdiomas){
        this.idiom=nuevosIdiomas;
    }

    public CVpersona copyCVpersona(){
        CVpersona copia=new CVpersona(this.grales,this.acad,this.labo,this.habi,this.idiom);
        return copia;
    }

    public static void main(String[]args){
        DatosGrales miDG=new DatosGrales("Axel", "Est", "Nav", 7, 2, 2000, "Tepic", "Mexico");
        DatosAcad miDA=new DatosAcad("Preparatoria", "UAM", 1, 2025, 1, 2027, "CDMX", "Mexico");
        DatosLabo miDL=new DatosLabo("Unilever","Intern",1,2020,1,2024,"Tultitlan","Mexico");
        Habilidades miHa=new Habilidades("Lectura", "Leer prron", "Avanzado");
        Idiomas miIdi=new Idiomas("Ingles", "Experto");
        CVpersona personaPrueba=new CVpersona(miDG, miDA, miDL, miHa, miIdi);
        personaPrueba.addLabo(new DatosLabo("Didi","Jefe",1,2020,1,2024,"Tultitlan","Mexico"));
        System.out.println(personaPrueba.getDatosLabo().get(1).getInstit());
    }
}
