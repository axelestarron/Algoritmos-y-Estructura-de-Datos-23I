package Pilas;
import Pilas.Nodo;

public class Filas<T>{
    Nodo<T> ultimo=new Nodo();
//Constructor
    Fila(){
        ultimo=null;
    }
//Vacio
    boolean vacio(){
        return this.ultimo==null;
    }
//Insertar
    void enqueue(T nuevoObjeto){
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
            Nodo<T> frente=this.ultimo.liga;
            if(frente==this.ultimo){
                this.ultimo=null;
            }else{
                this.ultimo.liga=frente.liga;
            }
        }
    }
//Acceder al último elemento
    T valorFrente(){
        if(this.vacia()){
            system.print.out("Error, la fila esta vacia");
            return null;
        }else{
            return this.ultimo.liga.info;
        }
    }
//pop
    T pop(){
        if(this.vacia()){
            system.print.out("Error, la fila esta vacia");
            return null;
        }else{
            this.valorFrente();
            this.dequeue();
        }
    }
//copia
    Filas<T> copia(){
        Filas<T> nuevaCopia= new Filas();
        nuevaCopia.ultimo=original.ultimo;
        return nuevaCopia;
    }
//Lectura completa
    void lecturaCompleta(){
        Filas<T> filaDeLectura=this.copia();
        if(this.vacio()){
            system.out.println("Su fila esta vacia");
        }
        while(filaDeLectura.vacio()==false){
            system.out.println(""+filaDeLectura.pop());
        }
    }
//el main
    public static void main(String[] arg){
        
    }
} 
