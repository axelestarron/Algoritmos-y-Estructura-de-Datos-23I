import java.util.Scanner;
public class ListasLineales<T>{
    Scanner input1=new Scanner(System.in);
    T info[];
    int ultimo;
    final int noValido=-1;
//constructor
    ListasLineales(){
        ultimo=noValido;
        System.out.println("Escriba el tamaño de su lista: ");
        int max=input1.nextInt();
        info=new T[max];
    }
    ListasLineales(int max){
        ultimo=noValido;
        info=new T[max];
    }
//Vacio
    private boolean vacia(){
        return ultimo==-1;
    }
//Busqueda
    private int buscarPosicion(T x){
        int i=0;
        while((i<=ultimo)&&(x.compareTo(info[i])<0)){
            i++;
        }
        return i;
    }
//Insertar
    private void insertar(T x){
        //Condición para determinar si existe espacio en la lista
        if(ultimo>=info.length-1){
            System.out.println("Error, la lista está llena");
        }else{
            int posicion=busca(x);
            //Condicion para determinar si el elemento ya existe
            if(info[pos].equals(x)){
                System.out.println("Error, este elemento ya existe");
            }
            else{
                int aux=++ultimo;
                while(aux>posicion){
                    info[aux]=info[aux-1];
                    aux--;
                }
                info[posicion]=x;
            }
        }
    }
//Borrar
    private void Borrar(T x){
        int pos=buscarPosicion(x);
        if(!info[pos].equals(x)){
            System.out.println("Error, este elemento no se encuentra.");
        }else{
            if(ultimo==pos){
                info[pos]=null;
                ultimo--;
            }else{
                while(pos<ultimo){
                    info[pos]=info[pos+1];
                    pos++;
                }
                ultimo--;
            }
        }
    }
}