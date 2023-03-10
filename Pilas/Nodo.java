package Pilas;
public class Nodo <T>{
    public T info;
    public Nodo<T> liga;
    //Constructor primer nodo    
    public Nodo(T datos){
        info=datos;
        liga=null;
    }
    //Constructor nodos concatenados
    public Nodo(T datos,Nodo<T> anterior){
        info=datos;
        liga=anterior;
    }

    //Equals
    boolean equals(Nodo<T> comparado){
        if(this==comparado) return true;
        if(this.getClass()!=comparado.getClass()) return false;
        if(this.info==comparado.info && this.liga==comparado.liga){
            return true;
        }else{
            return false;
        }
    }
    //Copy
    public Nodo<T> copiaDe(){
        Nodo<T> copia=new Nodo<T>(this.info,this.liga);
        return copia;
    }
    
    @Override
    public String toString(){
        return "Nodo [Info: "+this.info+", Liga: "+this.liga+"]";
    }
    //Metodos de servicio
    public void setInfo(T nuevoDato){
        this.info=nuevoDato;
    }
    public T getInfo(){
        return this.info;
    }
    public void setLiga(Nodo<T> nuevaLiga){
        this.liga=nuevaLiga;
    }
    public Nodo<T> getLiga(){
        return this.liga;
    }
}
