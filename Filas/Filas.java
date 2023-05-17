package Pilas;
import Pilas.Nodo;

public class Filas{
    Nodo ultimo=new Nodo();
//Constructor
    Fila(){
        ultimo=null;
    }
//Vacio
    boolean vacio(){
        return this.ultimo==null;
    }
//Insertar
    void enqueue(Object nuevoObjeto){
        if(this.vacio()){
            this.ultimo=new Nodo(nuevoObjeto,null);
            this.ultimo.liga=this.ultimo;
        }
        else{
            this.ultimo.liga=new Nodo(nuevoObjeto,this.ultimo.liga);
            this.ultimo=this.ultimo.liga;
        }
    }
//Borrar
    void dequeue(){
        if(this.vacio()){
            system.print.out("Error, la fila esta vacia");
        }else{
            Nodo frente=this.ultimo.liga;
            if(frente==this.ultimo){
                this.ultimo=null;
            }else{
                this.ultimo.liga=frente.liga;
            }
        }
    }
//Acceder al último elemento
    Object valorFrente(){
        if(this.vacia()){
            system.print.out("Error, la fila esta vacia");
            return null;
        }else{
            return this.ultimo.liga.info;
        }
    }
//pop
    Object pop(){
        if(this.vacia()){
            system.print.out("Error, la fila esta vacia");
            return null;
        }else{
            this.valorFrente();
            this.dequeue();
        }
    }
//el main
    public static void main(String[] arg){
        
    }
} 
