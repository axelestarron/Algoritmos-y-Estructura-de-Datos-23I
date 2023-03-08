package Pilas;
public class Nodo {
    public Object info;
    public Nodo liga;
    //Constructor primer nodo
    public Nodo(Object datos){
        info=datos;
        liga=null;
    }
    //Constructor nodos concatenados
    public Nodo(Object datos,Nodo anterior){
        info=datos;
        liga=anterior;
    }

    //Equals
    boolean equals(Nodo comparado){
        if(this==comparado) return true;
        if(this.getClass()!=comparado.getClass()) return false;
        if(this.info==comparado.info && this.liga==comparado.liga){
            return true;
        }else{
            return false;
        }
    }
    //Copy
    public Nodo copiaDe(){
        Nodo copia=new Nodo(this.info,this.liga);
        return copia;
    }
    
    @Override
    public String toString(){
        return "Nodo [Info: "+this.info+", Liga: "+this.liga+"]";
    }
}
