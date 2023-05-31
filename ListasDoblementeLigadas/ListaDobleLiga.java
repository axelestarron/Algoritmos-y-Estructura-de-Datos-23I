package ListasDoblementeLigadas;

public class ListaDobleLiga<T extends Comparable<T>> {
    NodoDL<T> cabeza;
//Constructor
    ListaDobleLiga(){
        this.cabeza=null;
    }
//vacia
    public boolean vacia(){
        return this.cabeza==null;
    }
//Busqueda
    public NodoDL<T> busqueda(T objComp){
        if(this.vacia()){
            return null;
        }
        NodoDL<T> aux=cabeza;
        while(aux.getLigaDer()!=null && aux.getInfo().compareTo(objComp)<0){
            aux=aux.getLigaDer();
        }
        if(aux.getInfo().compareTo(objComp)>0){
            aux=aux.getLigaIzq();
        }
        return aux;
    }


}
