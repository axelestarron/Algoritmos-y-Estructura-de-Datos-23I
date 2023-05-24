import Pilas.Nodo; 

class ListaDinamica<T extends Comparable<T>>{
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
        Nodo<T> aux=this.cabeza;
        while(aux!=null && aux.info.compareTo(ObjX)<0){
            aux=aux.liga;
        }
        return aux;
        //el método regresa un nodo cuando el elemento se encuentra dentro de la lista
        //regresa null cuando el elemento va al final de la lista
    }
//BuscaAnterior
private Nodo<T> buscaAnterior(T ObjX){
    Nodo<T> aux=cabeza;
    while(aux.liga!=null && aux.liga.info.compareTo(ObjX)<0){
        aux=aux.liga;
    }
    return aux;
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
            }else{ 
                //Si el elemento debe de ir en la cabeza
                if(cabeza==dir){
                    cabeza=new Nodo<T>(ObjIn,cabeza);
                }else{
                 //Si el elemento debe de ir en medio o al final de la lista
                    Nodo<T> previo=buscaAnterior(ObjIn);
                    previo.liga=new Nodo<T>(ObjIn,dir);
                }
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
        milista.insertar(5);
        milista.insertar(1);
        milista.insertar(2);
        milista.insertar(6);
        System.out.println(milista.toString());
    }
}
