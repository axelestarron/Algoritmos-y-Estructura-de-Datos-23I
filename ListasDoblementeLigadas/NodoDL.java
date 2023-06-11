package ListasDoblementeLigadas;

public class NodoDL<T>{
    private T info;
    private NodoDL<T> ligaIzq,ligaDer;
//Constructor
    public NodoDL(T elemento){
        this.info=elemento;
        this.ligaIzq=null;
        this.ligaDer=null;
    }
//Constructor con ligas
    public NodoDL(T elemento,NodoDL<T> ligaAnterior,NodoDL<T> ligaSiguiente){
        this.info=elemento;
        this.ligaIzq=ligaAnterior;
        this.ligaDer=ligaSiguiente;
    }
//Copy
    public NodoDL<T> copiaDe(){
        NodoDL<T> copia=new NodoDL<T>(this.getInfo(),this.getLigaIzq(),this.getLigaDer());
        return copia;
    }
//Metodos de servicio
    public void setInfo(T nuevoDato){
        this.info=nuevoDato;
    }
    public T getInfo(){
        return this.info;
    }
    public void setLigaIzq(NodoDL<T> nuevaLigaIzq){
        this.ligaIzq=nuevaLigaIzq;
    }
    public NodoDL<T> getLigaIzq(){
        return this.ligaIzq;
    }
    public void setLigaDer(NodoDL<T> nuevaLigaDer){
        this.ligaDer=nuevaLigaDer;
    }
    public NodoDL<T> getLigaDer(){
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
}
