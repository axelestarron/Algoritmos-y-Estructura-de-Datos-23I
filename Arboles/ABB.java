package Arboles;
import Filas.Filas;

public class ABB<T extends Comparable <T>> {
    //Datos miembro
    NodoArbol<T> raiz;
    //Constructor
    ABB(){
        this.raiz=null;
    }
    //vacio
    public boolean arbolVacio(){
        return this.raiz==null;
    }
    //busqueda recursiva
    private NodoArbol<T> busca(NodoArbol<T> raizDebusqueda,T elemento){
        //Declaración recursiva de busqueda de un elemento desde cierto nodo hacia abajo.
        if(raizDebusqueda==null||raizDebusqueda.getInfo().compareTo(elemento)==0) return raizDebusqueda;
        if(raizDebusqueda.getInfo().compareTo(elemento)<0){
            return busca(raizDebusqueda.getHijoIzq(), elemento);
        }else{
            return busca(raizDebusqueda.getHijoDer(), elemento);
        }
    }
    public NodoArbol<T> busquedaEnArbol(T x){
        //Aplicacion de busqueda recursiva donde siempre se empieza a buscar desde la raiz.
        return busca(this.raiz,x);
    }
    //Insertado recursivo
    private NodoArbol<T> inserta(NodoArbol<T>actual,T elemento){
        if(actual==null) return new NodoArbol<T>(elemento);
        if(elemento.compareTo(actual.getInfo())<0){
            actual.setHijoIzq(inserta(actual.getHijoIzq(),elemento));
        }else if(elemento.compareTo(actual.getInfo())>0){
            actual.setHijoDer(inserta(actual.getHijoDer(),elemento));
        }
        return actual;
    }
    public void insertaEnArbol(T x){
        this.raiz=inserta(raiz,x);
    }
    //Recorrido en preorden
    private void previo(Filas<T> cola,NodoArbol<T> raizDeRecorrido){
        if(raizDeRecorrido!=null){
            cola.enqueue(raizDeRecorrido.getInfo());
            this.previo(cola, raizDeRecorrido.getHijoIzq());
            this.previo(cola, raizDeRecorrido.getHijoDer());
        }
    }
    public void recorridoPreorden(){
        Filas<T> arbolRecorrido=new Filas<T>();
        this.previo(arbolRecorrido,this.raiz);
        arbolRecorrido.lecturaCompleta();
    }
    //Recorrido en inorden
    private void sincrono(Filas<T> cola,NodoArbol<T> raizDeRecorrido){
        if(raizDeRecorrido!=null){
            this.sincrono(cola, raizDeRecorrido.getHijoIzq());
            cola.enqueue(raizDeRecorrido.getInfo());
            this.sincrono(cola, raizDeRecorrido.getHijoDer());
        }
    }
    public void recorridoInorden(){
        Filas<T> arbolRecorrido=new Filas<T>();
        this.sincrono(arbolRecorrido,this.raiz);
        arbolRecorrido.lecturaCompleta();
    }
    //Recorrido en preorden
    private void posterior(Filas<T> cola,NodoArbol<T> raizDeRecorrido){
        if(raizDeRecorrido!=null){
            this.posterior(cola, raizDeRecorrido.getHijoIzq());
            this.posterior(cola, raizDeRecorrido.getHijoDer());
            cola.enqueue(raizDeRecorrido.getInfo());
        }
    }
    public void recorridoPosorden(){
        Filas<T> arbolRecorrido=new Filas<T>();
        this.posterior(arbolRecorrido,this.raiz);
        arbolRecorrido.lecturaCompleta();
    }
    //Recorrido por niveles
    public void recorridoNiveles(){
        Filas<T> arbolRecorrido=new Filas<T>();
        Filas<NodoArbol<T>> tempQueue=new Filas<NodoArbol<T>>();
        NodoArbol<T> tempNodo=new NodoArbol<T>(null);
        tempQueue.enqueue(this.raiz);
        while(!tempQueue.vacio()){
            tempNodo=tempQueue.pop();
            arbolRecorrido.enqueue(tempNodo.getInfo());
            if(tempNodo.getHijoIzq()!=null) tempQueue.enqueue(tempNodo.getHijoIzq());
            if(tempNodo.getHijoDer()!=null) tempQueue.enqueue(tempNodo.getHijoDer());
        }
        arbolRecorrido.lecturaCompleta();
    }
    //el main
    public static void main(String[]arg){
        ABB<Integer> miArbol=new ABB<Integer>();
        int[] miArray={50,17,72,12,23,54,76,9,14,19,67};
        for(int i=0;i<miArray.length;i++){
            miArbol.insertaEnArbol(miArray[i]);
        }
        miArbol.recorridoPreorden();
        miArbol.recorridoInorden();
        miArbol.recorridoPosorden();
        miArbol.recorridoNiveles();
    }
}
