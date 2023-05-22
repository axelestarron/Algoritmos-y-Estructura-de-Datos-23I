import Pilas.Nodo; 

class ListaDinamica<T>{
private Nodo<T> cabeza;
//Constructor
    ListaDinamica(){
        cabeza=null;
    }
//Vacia
    private boolean vacia(){
        return cabeza==null;
    }
//Buscar
    private Nodo<T> busca(T ObjX){
        Nodo<T> aux=cabeza;
        while(aux!=null && ((Comparable<T>) aux.info).compareTo(ObjX)<0){
            aux=aux.liga;
        }
        return aux;
    }
//BuscaAnterior
private Nodo<T> buscaAnterior(T ObjX){
    Nodo<T> aux=cabeza;
    Nodo<T> anterior=null;
    while(aux!=null && ((Comparable<T>) aux.info).compareTo(ObjX)<0){
        anterior=aux;
        aux=aux.liga;
    }
    return anterior;
}
//Insertar
    private void insertar(T ObjIn){
        //Si la lista esta vacia
        if(this.vacia()){
            cabeza=new Nodo<T>(ObjIn,null);
        }
        else{
            Nodo<T> dir=busca(ObjIn);
            //Si la lista ya contiene el elemento que se va a insertar
            if(dir!=null && dir.info.equals(ObjIn)){
                System.out.println("Este elemento ya se encuentra en la lista");
            }else 
            //Si el elemento debe de ir en la cabeza
            if(cabeza==dir){
                cabeza=new Nodo<T>(ObjIn,cabeza);
            }
            //Si el elemento debe de ir en medio o al final de la lista
            else{
                Nodo<T> previo=buscaAnterior(dir.info);
                previo.liga=new Nodo<T>(ObjIn,dir);
            }
        }
    }
//ToString
    @Override
    public String toString(){  
        String texto="";
        Nodo<T> aux=this.cabeza;
        while(aux!=null){
            texto=texto+" "+aux.info;
            aux=aux.liga;
        }
        return texto;
    }

//El main
    public static void main(String[]arg){
        ListaDinamica<Integer> milista=new ListaDinamica<Integer>();
        milista.insertar(2);
        milista.insertar(4);
        System.out.println(milista.toString());
    }
}
