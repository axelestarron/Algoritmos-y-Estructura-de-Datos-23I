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

    TareaArreglos(int tamaño) {
        Scanner entradaArreglo = new Scanner(System.in);
        miArreglo = new int[tamaño];
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

    public static String[] stringSort(String[] a){
        String[] arregloStrings=a;
        int min; 
        String temp;
        for (int i = 0; i < (arregloStrings.length - 1); i++) {
            min = i;

            for (int j = i + 1; j < arregloStrings.length; j++) {
                if (arregloStrings[j].compareTo(arregloStrings[min])<0) {
                    min = j;
                }
            }

            temp = arregloStrings[min];
            arregloStrings[min] = arregloStrings[i];
            arregloStrings[i] = temp;
        }
        return arregloStrings;
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

    public static void ejercicio1(int selector){
        switch(selector){
            case 1:
                //Ejercicio 1.a
                int[] a={4,8,6,2,5};
                TareaArreglos ejercicio1a=new TareaArreglos(a);
                ejercicio1a.insertSort();
                System.out.println(ejercicio1a.toString());
                break;
            case 2:
                //Ejercicio 1.b
                String listaDeNumeros=new String(fileReader("numeros.txt"));
                int[] b=string2IntArray(listaDeNumeros);
                TareaArreglos ejercicio1b=new TareaArreglos(b);
                ejercicio1b.insertSort();
                System.out.println(ejercicio1b.toString());
                break;
            case 3:
                //Ejercicio 1.c
                String[] arregloCadenas={"Hola","Adios", "Gracias", "Denada", "Por Favor", "Algoritmo", "Java", "Programación","Axel","Naomi"};
                arregloCadenas=stringSort(arregloCadenas);
                for(int i=0;i<10;i++){
                    System.out.println(arregloCadenas[i]);
                }
                break;
        }
    }

    public static void ejercicio2(int selector){
        System.out.println("Este programa proporciona el número de elementos pares, impares, positivos, negativos, nulos (0) y positivos pares de un arreglo de "+selector+" elementos.");
        TareaArreglos numEntry=new TareaArreglos(selector);
        TareaArreglos pares=numEntry;
        pares.onlyEvenOrOdd(0);
        System.out.println("Se tienen "+pares.miArreglo.length+" numeros pares: "+pares.toString());
        TareaArreglos impares=numEntry;
        impares.onlyEvenOrOdd(1);
        System.out.println("Se tienen "+impares.miArreglo.length+" numeros impares: "+impares.toString());
        TareaArreglos positivos=numEntry;
        positivos.onlyThisSign(1);
        System.out.println("Se tienen "+positivos.miArreglo.length+" numeros positivos: "+positivos.toString());
        TareaArreglos negativos=numEntry;
        negativos.onlyThisSign(-1);
        System.out.println("Se tienen "+negativos.miArreglo.length+" numeros negativos: "+negativos.toString());
        TareaArreglos ceros=numEntry;
        ceros.onlyThisSign(0);
        System.out.println("Se tienen "+ceros.miArreglo.length+" ceros.");
        pares.onlyThisSign(1);
        System.out.println("Se tienen "+pares.miArreglo.length+" numeros positivos pares: "+pares.toString());
    }
    
    public static void main(String[] arg){
        ejercicio2(5);
    }
}

