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
    //el main
    public static void main(String[]arg){
        ABB<Integer> miArbol=new ABB<Integer>();
        int[] miArray={6,14,4,7,8,12,3,1,2,10};
        for(int i=0;i<miArray.length;i++){
            miArbol.insertaEnArbol(miArray[i]);
        }
        miArbol.recorridoPreorden();
        System.out.println(miArbol.raiz.getHijoDer().getInfo().toString());
    }
}
