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
    @Override
    public String toString(){
        if(this.vacia()){
            return "La pila está vacia";
        }else{
            PilasDinamicas copia=new PilasDinamicas();
            copia.tope=this.tope.copiaDe();
            String texto="";
            int i=0;
            do{
                texto+="Nodo[n-"+ i++ +"] :"+copia.pop()+"\n";
            }while(copia.vacia()==false);
            return texto;
        }
        
    }

    public static void main(String[] arg){
        PilasDinamicas miPila=new PilasDinamicas();
        miPila.insertar(10);
        miPila.insertar(new String("Hola"));
        miPila.insertar(new String("adios"));
        System.out.println(miPila.toString());
    }
}
