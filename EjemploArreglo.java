import java.util.Scanner;

public class EjemploArreglo {
    int miArreglo[];
//métodos constructores
    EjemploArreglo(){
        Scanner entradaArreglo=new Scanner(System.in);
        System.out.print("Introduzca el tamaño de su arreglo: ");
        int capacidad=entradaArreglo.nextInt();
        miArreglo=new int[capacidad];

        System.out.println("\n"+"Introduzca los elementos del arreglo.");
        for (int i=0;i<miArreglo.length;i++){
            System.out.print("Elemento "+ (i+1)+": ");
            miArreglo[i]=entradaArreglo.nextInt();
        }
        entradaArreglo.close();
    }
        
    EjemploArreglo(int tamaño){
        Scanner entradaArreglo=new Scanner(System.in);
        miArreglo=new int[tamaño];
            System.out.println("\n"+"Introduzca los elementos del arreglo.");

        for (int i=0;i<miArreglo.length;i++){
            System.out.print("Elemento "+ (i+1)+": ");
            miArreglo[i]=entradaArreglo.nextInt();
        }
        entradaArreglo.close();
    }

    EjemploArreglo(int a[]){
        this.miArreglo=a;
    }
//métodos para los arreglos
    public int suma(){
        int result=0;
        for (int i=0;i<miArreglo.length;i++){
            result=result+miArreglo[i];
        }
        return result;
    }

    public int maximo(){
        int result=miArreglo[0];
        for (int i=1;i<miArreglo.length;i++){
            if(miArreglo[i]>result){
                result=miArreglo[i];
            }
        }
        return result;
    }

    public int posMaximo(){
        int posMax=0;
        for (int i=1;i<miArreglo.length;i++){
            if(miArreglo[i]>miArreglo[posMax]){
                posMax=i;
            }
        }
        return posMax;
    }

    public int valorMedio(){
        return miArreglo[ miArreglo.length /2];
    }

    public double promedio(){
       double prom= this.suma();
       prom=prom/2;
       return prom;
    }

    @Override
    public String toString(){
        String result=new String("{"+ this.miArreglo[0]);
        for (int i=1;i<this.miArreglo.length;i++){
            result=result.concat(","+ this.miArreglo[i]);
        }
        result=result.concat("}");
        return result;
    }
//el main 
    public static void main(String[] arg){
        int a[]={1,2,3,4,5};
        EjemploArreglo abominacion=new EjemploArreglo(a);
        System.out.println(abominacion.toString());
        System.out.println("La suma de los elementos del arreglo es: "+ abominacion.suma());
        System.out.println("El máximo de su arreglo es: "+ abominacion.maximo() + ", en el indice: " + abominacion.posMaximo());
        System.out.println("El valor medio es: " + abominacion.valorMedio() + ", en el indice: " + abominacion.miArreglo.length /2);
        System.out.println("El promedio de su arreglo es: "+ abominacion.promedio()); 
    }
}
 

