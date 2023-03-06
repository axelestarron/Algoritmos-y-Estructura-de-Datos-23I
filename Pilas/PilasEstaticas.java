package Pilas;
public class PilasEstaticas{
    public int tope;
    public Object[] info;

    PilasEstaticas(int a){
        tope=-1;
        info=new Object[a];
    }

    boolean vacia(){
        //determina si la pila está vacía
        if (this.tope==-1){
            return true;
        }else{
            return false;
        }
    }

    void insertar(Object insertado){
        if(tope==(info.length-1)){
            System.out.println("Error, esta pila ya está llena");
        }else{
            info[++tope]=insertado;
        }
    }

    Object pop(){
        if(this.vacia()){
            System.out.println("Error, esta pila está vacia");
            return null;
        }else{
            return info[tope--];

        }
    }

    Object valTope(){
        if(this.vacia()){
            System.out.println("Error, esta pila está vacia");
            return null;
        }else{
            return info[tope];

        }
    }

    @Override
    public String toString(){
        if(this.vacia()){
            System.out.println("Error, la pila está vacia");
            return "";
        }else{
            String miTexto=new String("");
            for(int i=tope;i>=0;i--){
                if(i==tope){
                    miTexto=miTexto+info[i].toString();
                }else{
                    miTexto=miTexto+", "+info[i].toString();
                }
            }
            return miTexto;
        }
    }
}