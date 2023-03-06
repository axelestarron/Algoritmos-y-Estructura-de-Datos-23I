package Pilas;
public class PilasDinamicas {
    Nodo tope;
    //constructor de pila vacia
    PilasDinamicas(){
        tope=null;
    }
    //empty method
    boolean vacia(){
        if(tope==null){
            return true;
        }else{
            return false;
        }
    }
    //insert
    void insertar(Object insertado){
        tope=new Nodo(insertado, tope);
    }
    //pop
    Object pop(){
        if(this.vacia()){
            System.out.println("La pila está vacia");
            return null;
        }else{
            Object aux=tope.info;
            tope=tope.liga;
            return aux;
        }
    }
    //access method
    Object valTope(){
        if(tope==null){
            System.out.println("La pila está vacia");
            return tope;
        }else{
            return tope.info;
        }
    }
}
