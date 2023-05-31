package ListasDoblementeLigadas;

public class NodoDL{
    private Comparable info;
    private NodoDL ligaIzq,ligaDer;
//Constructor
    public NodoDL(Comparable elemento){
        this.info=elemento;
        this.ligaIzq=null;
        this.ligaDer=null;
    }
//Constructor con ligas
    public NodoDL(Comparable elemento,NodoDL ligaAnterior,NodoDL ligaSiguiente){
        this.info=elemento;
        this.ligaIzq=ligaAnterior;
        this.ligaDer=ligaSiguiente;
    }
//Copy
    public NodoDL copiaDe(){
        NodoDL copia=new NodoDL(this.getInfo(),this.getLigaIzq(),this.getLigaDer());
        return copia;
    }
//Metodos de servicio
    public void setInfo(Comparable nuevoDato){
        this.info=nuevoDato;
    }
    public Comparable getInfo(){
        return this.info;
    }
    public void setLigaIzq(NodoDL nuevaLigaIzq){
        this.ligaIzq=nuevaLigaIzq;
    }
    public NodoDL getLigaIzq(){
        return this.ligaIzq;
    }
    public void setLigaDer(NodoDL nuevaLigaDer){
        this.ligaDer=nuevaLigaDer;
    }
    public NodoDL getLigaDer(){
        return this.ligaDer;
    }
//toString
    @Override
    public String toString(){
        if(this.ligaIzq==null){
            if(this.ligaDer==null){
                return "Nodo[Liga anterior: vacia; Info: "+this.info.toString()+"; Liga siguiente: vacia]";
            }else{
                return "Nodo[Liga anterior: vacia; Info: "+this.info.toString()+"; Liga siguiente: "+this.ligaDer.getInfo().toString()+"]";
            }
        }else if(this.ligaDer==null){
            return "Nodo[Liga anterior: "+this.ligaIzq.getInfo().toString()+"; Info: "+this.info.toString()+"; Liga siguiente: vacia]";
        }else{
            return "Nodo[Liga anterior: "+this.ligaIzq.getInfo().toString()+"; Info: "+this.info.toString()+"; Liga siguiente: "+this.ligaDer.getInfo().toString()+"]";
        }
    }
//El main
    public static void main(String[] arg){
        NodoDL miNodo=new NodoDL("pepino");
        NodoDL otroNodo=new NodoDL("percebes",miNodo,null);
        System.out.println(otroNodo.toString());
    }
}
