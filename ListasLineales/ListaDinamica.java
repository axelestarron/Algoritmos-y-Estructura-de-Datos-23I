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
        while(aux!=null && aux.getInfo().compareTo(ObjX)<0){
            aux=aux.getLiga();
        }
        return aux;
        //el método regresa un nodo cuando el elemento se encuentra dentro de la lista
        //regresa null cuando el elemento va al final de la lista
    }
//BuscaAnterior
private Nodo<T> buscaAnterior(T ObjX){
    Nodo<T> aux=cabeza;
    while(aux.getLiga()!=null && aux.getLiga().getInfo().compareTo(ObjX)<0){
        aux=aux.getLiga();
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
            if(dir!=null && dir.getInfo().equals(ObjIn)){
                System.out.println("Este elemento ya se encuentra en la lista");
            }else{ 
                //Si el elemento debe de ir en la cabeza
                if(cabeza==dir){
                    cabeza=new Nodo<T>(ObjIn,cabeza);
                }else{
                 //Si el elemento debe de ir en medio o al final de la lista
                    Nodo<T> previo=buscaAnterior(ObjIn);
                    previo.setLiga(new Nodo<T>(ObjIn,dir));
                }
            }    
        }
    }
//Borrar
    public void borrar(T ObjBorrado){
        Nodo<T> aux=this.busca(ObjBorrado);
        if(aux==null || !aux.getInfo().equals(ObjBorrado)){
            System.out.println("Error, el elemento --"+ObjBorrado.toString()+"-- no se encuentra");
        }else if(aux==this.cabeza){
            cabeza=aux.getLiga();
            System.out.println("El elemento --"+ ObjBorrado.toString()+ "-- será borrado");
        }else{
            System.out.println("El elemento --"+ ObjBorrado.toString()+ "-- será borrado");
            Nodo<T> auxAnterior=this.buscaAnterior(ObjBorrado);
            auxAnterior.setLiga(aux.getLiga());
        }
    }
//ToString
    @Override
    public String toString(){  
        String texto="[";
        Nodo<T> aux=this.cabeza;
        while(aux!=null){
            texto=texto+" "+aux.getInfo().toString();
            aux=aux.getLiga();
        }
        texto=texto+" ]";
        return texto;
    }
//El main
    public static void main(String[]arg){
        ListaDinamica<String> milista=new ListaDinamica<String>();
        milista.insertar("Casa");
        milista.insertar("Perro");
        milista.insertar("Aldair");
        milista.insertar("Batman");
        milista.borrar("Batman");
        milista.borrar("Patito");
        System.out.println(milista.toString());
    }
}
