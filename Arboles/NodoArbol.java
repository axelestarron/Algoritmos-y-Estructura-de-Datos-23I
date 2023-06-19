package Arboles;

public class NodoArbol<T extends Comparable<T>> {
    //Datos miembro
    T info;
    NodoArbol<T> hijoIzq;
    NodoArbol<T> hijoDer;
    //Constructor vacío
    NodoArbol(T elemento){
        this.info=elemento;
        this.hijoIzq=null;
        this.hijoDer=null;
    }
    //Constructor con nodos
    NodoArbol(T elemento,NodoArbol<T> ligaIzq,NodoArbol<T> ligaDer){
        this.info=elemento;
        this.hijoIzq=ligaIzq;
        this.hijoDer=ligaDer;
    }
    //Metodos de servicio
    public void setInfo(T nuevoDato){
        this.info=nuevoDato;
    }
    public T getInfo(){
        return this.info;
    }
    public void setHijoIzq(NodoArbol<T> nuevaLigaIzq){
        this.hijoIzq=nuevaLigaIzq;
    }
    public NodoArbol<T> getHijoIzq(){
        return this.hijoIzq;
    }
    public void setHijoDer(NodoArbol<T> nuevaLigaDer){
        this.hijoDer=nuevaLigaDer;
    }
    public NodoArbol<T> getHijoDer(){
        return this.hijoDer;
    }
    //toString
    @Override
    public String toString(){
        if(this.hijoIzq==null){
            if(this.hijoDer==null){
                return "NodoArbol[Hijo izquierdo: vacio; Info: "+this.info.toString()+"; Hijo Derecho: vacio]";
            }else{
                return "Nodo[Hijo izquierdo: vacio; Info: "+this.info.toString()+"; Hijo Derecho: "+this.hijoDer.getInfo().toString()+"]";
            }
        }else if(this.hijoDer==null){
            return "Nodo[Hijo izquierdo: "+this.hijoIzq.getInfo().toString()+"; Info: "+this.info.toString()+"; Hijo Derecho: vacio]";
        }else{
            return "Nodo[Hijo izquierdo: "+this.hijoIzq.getInfo().toString()+"; Info: "+this.info.toString()+"; Hijo Derecho: "+this.hijoDer.getInfo().toString()+"]";
        }
    }
}
