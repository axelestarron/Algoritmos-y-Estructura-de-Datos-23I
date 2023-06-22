package Arboles;
import Filas.Filas;
import Principal.Manzana;

import java.util.Random;
//Ejercicio 1. Implementar la clase ABB con los siguientes métodos:
//vacia; buscar, borrar e insertar (recursivo);recorrido en preorden, inorden, posorden y por niveles.
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
    public void recorridoPostorden(){
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
        //Ejercicio 2. 
        System.out.println("\n2. Insertar la siguiente lista de nodos en un arbol vacio:[2,4,6,8,10,12,14,16].");
        System.out.println("Recorra en preorden y postorden.");
        int[] arrayEnteros={2,4,6,8,10,12,14,16};
        ABB<Integer> arbolEnteros=new ABB<Integer>();
        for(int i=0;i<arrayEnteros.length;i++){
           arbolEnteros.insertaEnArbol(arrayEnteros[i]);
        }
        //Recorra en preorden y posorden
        System.out.print("\tPreorden: ");
        arbolEnteros.recorridoPreorden();
        System.out.print("\tPostorden: ");
        arbolEnteros.recorridoPostorden();
        //Insertar 10 y 5, recorrer en inorden.
        System.out.println("Inserte el 10 y el 5, y recorra en inorden");
        System.out.print("\tInorden: ");
        arbolEnteros.insertaEnArbol(10);
        arbolEnteros.insertaEnArbol(5);
        arbolEnteros.recorridoInorden();
        
        //Ejercicio 3.
        System.out.println("\n3. Insertar la siguiente lista de nodos en un arbol vacio:[50,40,30,20,10,5].");
        System.out.println("Recorra en preorden, postorden e inorden.");
        int[] otroArrayEnteros={50,40,30,20,10,5};
        ABB<Integer> otroArbolEnteros=new ABB<Integer>();
        for(int i=0;i<otroArrayEnteros.length;i++){
           otroArbolEnteros.insertaEnArbol(otroArrayEnteros[i]);
        }
        //Preorden
        System.out.print("\tPreorden: ");
        otroArbolEnteros.recorridoPreorden();
        //Postorden
        System.out.print("\tPostorden: ");
        otroArbolEnteros.recorridoPostorden();
        //Inorden
        System.out.print("\tInorden: ");
        otroArbolEnteros.recorridoInorden();

        //Ejercicio 4.
        System.out.println("\n4. Insete en un arbol ABB vacio 20 numeros aleatorios.");
        System.out.println("Recorra en preorden, postorden, inorden y por niveles.");
        ABB<Integer> arbolRandom=new ABB<Integer>();
        //Se debe importar la clase Random para poder generar numeros aleatorios en cada ejecucion.
        Random randomInt=new Random();
        int[] nextRandom=new int[20];
        for(int i=0;i<20;i++){
            nextRandom[i]=randomInt.nextInt(50);
            arbolRandom.insertaEnArbol(nextRandom[i]);
        }
        //Imprimir el array de numeros random en el orden que se insertaron
        System.out.print("\tLos 20 numeros aleatorios insertados fueron: ");
        for(int i=0;i<20;i++){
            if(i==0){
                System.out.print("["+nextRandom[i]);
            }else if(i!=19){
                System.out.print(", "+nextRandom[i]);
            }else{
                System.out.println(", "+nextRandom[i]+"]");
            }
        }
        //Preorden
        System.out.print("\tPreorden: ");
        arbolRandom.recorridoPreorden();
        //Postorden
        System.out.print("\tPostorden: ");
        arbolRandom.recorridoPostorden();
        //Inorden
        System.out.print("\tInorden: ");
        arbolRandom.recorridoInorden();
        //Por niveles
        System.out.print("\tPor niveles: ");
        arbolRandom.recorridoNiveles();

        //Ejercicio 5.
        System.out.println("\n5. Utilice la clase manzana, crea 10 manzanas e insertalas en un arbol ABB.");
        System.out.println("Recorra en inorden y por niveles.");
        ABB<Manzana> arbolDeManzanas=new ABB<Manzana>();
        int[] pesoArray={50,17,72,12,23,54,76,9,14,19};
        String[] variedadArray={"Ralls Genet","Fuji","Golden","Granny Smith","Reineta","Red Delicious","Starking","Gala","Lady William","Cripps Pink"};
        String[] colorArray={"Roja","Verde","Dorada","Rosa"};
        System.out.println("\tLas 10 manzanas que se insertaron al arbol fueron: ");
        Manzana manzanaAux;
        for(int i=0;i<pesoArray.length;i++){
            int a=i%4;
            manzanaAux=new Manzana(variedadArray[i],colorArray[a],pesoArray[i]);
            arbolDeManzanas.insertaEnArbol(manzanaAux);
            System.out.println("\t\t"+manzanaAux.toString());
        }
        //Recorrido en inorden
        System.out.print("\tInorden: ");
        arbolDeManzanas.recorridoInorden();
        //Recorrido por niveles
        System.out.print("\tPor niveles: ");
        arbolDeManzanas.recorridoNiveles();
        //miArbol.recorridoPreorden();
        //miArbol.recorridoInorden();
        //miArbol.recorridoPosorden();
        
    }
}
