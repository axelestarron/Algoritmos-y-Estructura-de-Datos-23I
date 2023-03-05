public class Nodo {
    Object info;
    Nodo liga;
    //Constructor primer nodo
    Nodo(Object datos){
        info=datos;
        liga=null;
    }
    //Constructor nodos concatenados
    Nodo(Object datos,Nodo anterior){
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
    
    
}
