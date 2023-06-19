package Filas;
import Pilas.Nodo;

public class Filas<T>{
    Nodo<T> ultimo;
//Constructor
    public Filas(){
        ultimo=null;
    }
//Vacio
    public boolean vacio(){
        return this.ultimo==null;
    }
//Insertar
    public void enqueue(T nuevoObjeto){
        if(this.vacio()){
            this.ultimo=new Nodo<T>(nuevoObjeto,null);
            this.ultimo.liga=this.ultimo;
        }
        else{
            this.ultimo.liga=new Nodo<T>(nuevoObjeto,this.ultimo.liga);
            this.ultimo=this.ultimo.liga;
        }
    }
//Borrar
    public void dequeue(){
        if(this.vacio()){
            System.out.println("Error, la fila esta vacia");
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
        if(this.vacio()){
            System.out.println("Error, la fila esta vacia");
            return null;
        }else{
            return this.ultimo.liga.info;
        }
    }
//pop
    T pop(){
        if(this.vacio()){
            System.out.println("Error, la fila esta vacia");
            return null;
        }else{
            T result=this.valorFrente();
            this.dequeue();
            return result;
        }
    }
//copia
    Filas<T> copia(){
        Filas<T> nuevaCopia=new Filas<T>();
        nuevaCopia.ultimo=this.ultimo;
        return nuevaCopia;
    }
//Lectura completa
    public void lecturaCompleta(){
        Filas<T> filaDeLectura=this.copia();
        if(this.vacio()){
            System.out.println("Su fila esta vacia");
        }else{
            System.out.print("["+filaDeLectura.pop().toString());
            while(filaDeLectura.vacio()==false){
                System.out.print(", "+filaDeLectura.pop().toString());
            }
            System.out.println("]");
        }
        
    }
//el main
    public static void main(String[] arg){
        Filas<String> mifila=new Filas<String>();
        mifila.enqueue("Primero");
        mifila.enqueue("Segundo");
        mifila.enqueue("Tercero");
        mifila.enqueue("La rosalía");
        System.out.println(mifila.valorFrente());
        mifila.lecturaCompleta();
    }
} 
