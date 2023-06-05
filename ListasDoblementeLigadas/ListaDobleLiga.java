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
//Borrar
    public void borrar(T objBorrado){
        NodoDL<T> aux=this.busqueda(objBorrado);
        if(aux==null||!aux.getInfo().equals(objBorrado)){
            System.out.println("Error, el elemento --"+objBorrado.toString()+"-- no se encuentra en la lista.");
        }else{
            if(aux.getLigaIzq()==null){
                if(aux.getLigaDer()==null){
                    this.cabeza=null;
                }else{
                    this.cabeza=aux.getLigaDer();
                    this.cabeza.setLigaIzq(null);
                }
            }else if(aux.getLigaDer()==null){
                aux.getLigaIzq().setLigaDer(null);
            }else{
                aux.getLigaIzq().setLigaDer(aux.getLigaDer());
                aux.getLigaDer().setLigaIzq(aux.getLigaIzq());
            }
        }
    }
//Insertar
    public void insertar(T objInsertado){
        NodoDL<T> aux=this.busqueda(objInsertado);
        if(aux!=null && aux.getInfo().equals(objInsertado)){
            System.out.println("Error, el elemento --"+objInsertado.toString()+"-- ya se encuentra en la lista.");
        }else if(aux==null){
            this.cabeza=new NodoDL<T>(objInsertado,null,this.cabeza);
            if(this.cabeza.getLigaDer()!=null){
                this.cabeza.getLigaDer().setLigaIzq(this.cabeza);
            }
        }else{
            aux.setLigaDer(new NodoDL<T>(objInsertado,aux,aux.getLigaDer()));
            if(aux.getLigaDer().getLigaDer()!=null){
                aux.getLigaDer().getLigaDer().setLigaIzq(aux.getLigaDer());
            }
        }
    }
//Contador
    public int longitud(){
        int n=0;
        NodoDL<T> aux=cabeza;
        while(aux!=null){
            n++;
            aux=aux.getLigaDer();
        }
        return n;
    }
//Busqueda con indice
    public NodoDL<T> busquedaN(int i){
        if(this.vacia()){
            System.out.println("Error, la lista está vacia");
            return null;
        }else if((i>longitud()-1)||(i<0)){
            System.out.println("Error, el índice no se encuentra dentro de la lista");
            return null;
        }else{
            int n=0;
            NodoDL<T> aux=cabeza;
            while(n<i){
                n++;
                aux=aux.getLigaDer();
            }
            return aux;
        }
        
    }
//Clonado de la lista
    public ListaDobleLiga<T> copia(){
        NodoDL<T> aux=cabeza;
        ListaDobleLiga<T> copia=new ListaDobleLiga<T>();
        while(aux!=null){
            copia.insertar(aux.getInfo());
            aux=aux.getLigaDer();
        }
        return copia;
    }
//toString
    @Override
    public String toString(){
        String texto="[";
        NodoDL<T> aux=this.cabeza;
        while(aux!=null){
            texto=texto+" "+aux.getInfo().toString();
            aux=aux.getLigaDer();
        }
        texto=texto+" ]";
        return texto;
    }
//El main
    public static void main(String[] arg){
        ListaDobleLiga<String> miLista=new ListaDobleLiga<String>();
        miLista.insertar("Aldair");
        miLista.insertar("Bob Esponja");
        miLista.insertar("Barco");
        miLista.insertar("Don Cangrejo");
        miLista.insertar("Naomi");
        ListaDobleLiga<String> copia=miLista.copia();
        copia.borrar("Barco");
        System.out.println(miLista.toString());
        System.out.println(copia.toString());
    }

}
