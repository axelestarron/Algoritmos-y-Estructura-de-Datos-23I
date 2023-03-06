package Tareas;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

public class TareaArreglos {
    //1. Implemente en Java el algoritmo  de ordenamiento por seleccion visto en clase utilizando:
    //a)4,8,,6,2,5 ; b) Crear un archivo con 30 números aleatorios entre 0 y 100; c)Crear 10
    //strings y ordenarlos con el algoritmo.
    //2. Utilizando la clase Arreglos (con elementos enteros), implemente las funciones que permitan
    //determinar: a)# positivos b) # negativos, c) #pares, d)#impares e) # de ceros, f)# positivos pares
    int miArreglo[];

    TareaArreglos() {
        Scanner entradaArreglo = new Scanner(System.in);
        System.out.print("Introduzca el tamaño de su arreglo: ");
        int capacidad = entradaArreglo.nextInt();
        miArreglo = new int[capacidad];

        System.out.println("\n" + "Introduzca los elementos del arreglo.");
        for (int i = 0; i < miArreglo.length; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            miArreglo[i] = entradaArreglo.nextInt();
        }
        entradaArreglo.close();
    }

    TareaArreglos(int a[]) {
        this.miArreglo = a;
    }

    public void insertSort() {
        int min, temp;
        for (int i = 0; i < (this.miArreglo.length - 1); i++) {
            min = i;

            for (int j = i + 1; j < this.miArreglo.length; j++) {
                if (this.miArreglo[j] < this.miArreglo[min]) {
                    min = j;
                }
            }

            temp = this.miArreglo[min];
            this.miArreglo[min] = this.miArreglo[i];
            this.miArreglo[i] = temp;
        }
    }

    public static String fileReader(String source){
        try {
            File myFile=new File(source);
            Scanner fileScanner=new Scanner(myFile);
            String data=fileScanner.nextLine();
            fileScanner.close();
            return data;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }
    }

    public static int[] string2IntArray(String lista){
        StringTokenizer myST=new StringTokenizer(lista);    
        int[] arregloNumeros=new int[myST.countTokens()];
        for(int i=0;i<arregloNumeros.length;i++){
            try{
                arregloNumeros[i]= Integer.valueOf(myST.nextToken());
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }
        }
        return arregloNumeros;
    }

    @Override
    public String toString() {
        String result = new String("{" + this.miArreglo[0]);
        for (int i = 1; i < this.miArreglo.length; i++) {
            result = result.concat("," + this.miArreglo[i]);
        }
        result = result.concat("}");
        return result;
    }
    
    public void onlyThisSign(int signo){
        int contador=0;
        int[] seleccionados=new int[this.miArreglo.length];
        switch(signo){
            case 1:
                for(int i=0;i<this.miArreglo.length;i++){
                    if(this.miArreglo[i]>0){
                        seleccionados[contador]=this.miArreglo[i];
                        contador++;
                    } 
                }
            break;
            case -1:
                for(int i=0;i<this.miArreglo.length;i++){
                    if(this.miArreglo[i]<0){
                        seleccionados[contador]=this.miArreglo[i];
                        contador++;
                    } 
                }
            break;
            case 0:
                for(int i=0;i<this.miArreglo.length;i++){
                    if(this.miArreglo[i]==0){
                        seleccionados[contador]=this.miArreglo[i];
                        contador++;
                    } 
                }
            break;
        }   
        int[] resultado=new int[contador];
        for(int i=0;i<contador;i++){
            resultado[i]=seleccionados[i];
        }
        this.miArreglo=resultado; 
    }

    public void onlyEvenOrOdd(int mod){
        int contador=0;
        int[] seleccionados=new int[this.miArreglo.length];
        switch(mod){
            case 1:
                for(int i=0;i<this.miArreglo.length;i++){
                    if(this.miArreglo[i]%2==1){
                        seleccionados[contador]=this.miArreglo[i];
                        contador++;
                    } 
                }
            break;
            case 0:
                for(int i=0;i<this.miArreglo.length;i++){
                    if(this.miArreglo[i]%2==0){
                        seleccionados[contador]=this.miArreglo[i];
                        contador++;
                    } 
                }
            break;
        }   
        int[] resultado=new int[contador];
        for(int i=0;i<contador;i++){
            resultado[i]=seleccionados[i];
        }
        this.miArreglo=resultado; 
    }
    public static void main(String[] arg){
        //Ejercicio 1.a
        int[] a={4,8,6,2,5};
        TareaArreglos ejercicio1a=new TareaArreglos(a);
        ejercicio1a.insertSort();
        System.out.println(ejercicio1a.toString());
        //Ejercicio 1.b
        String listaDeNumeros=new String(fileReader("numeros.txt"));
        int[] b=string2IntArray(listaDeNumeros);
        TareaArreglos ejercicio1b=new TareaArreglos(b);
        ejercicio1b.insertSort();
        System.out.println(ejercicio1b.toString());
        //Ejercicio 2.a
        int[] prueba={-1,3,5,7,11,-44,-67,-11,0,1,0,7,0,99};
        TareaArreglos chuerk=new TareaArreglos(prueba);
        chuerk.onlyEvenOrOdd(1);
        System.out.println(chuerk.toString());
    }
}
