public class Filas<T>{
    Nodo<T> ultimo;
//Constructor
    Filas(){
        ultimo=null;
    }
//Vacio
    boolean vacio(){
        return this.ultimo==null;
    }
//Insertar
    void enqueue(T nuevoObjeto){
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
    void dequeue(){
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
            this.valorFrente();
            this.dequeue();
        }
    }
//copia
    Filas<T> copia(){
        Filas<T> nuevaCopia= new Filas<T>();
        nuevaCopia.ultimo.info=this.ultimo.info;
        nuevaCopia.ultimo.liga=this.ultimo.liga;
        return nuevaCopia;
    }
//Lectura completa
    void lecturaCompleta(){
        Filas<T> filaDeLectura=this.copia();
        if(this.vacio()){
            System.out.println("Su fila esta vacia");
        }
        while(filaDeLectura.vacio()==false){
            System.out.println(""+filaDeLectura.pop());
        }
    }
//el main
    public static void main(String[] arg){
        
    }
} 
