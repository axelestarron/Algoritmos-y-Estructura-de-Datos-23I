package Filas;
import Pilas.Nodo;
public class Filas<T>{
    Nodo<T> ultimo;
    //Constructor vacio
    public Filas(){
        ultimo=null;
    }
    //FilaVacia
    boolean vacia(){
        if(ultimo==null){
            return true;
        }else{
            return false;
        }
    }
    //Primero en la fila
    public void inQueue(T info){{
        if(this.vacia()){
            Nodo<T> nuevo=new Nodo<T>(info);
            
        }

    }

    }
}
