package Tareas;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

public class TareaArreglos {
    // 1. Implemente en Java el algoritmo de ordenamiento por seleccion visto en
    // clase utilizando:
    // a)4,8,,6,2,5 ; b) Crear un archivo con 30 números aleatorios entre 0 y 100;
    // c)Crear 10
    // strings y ordenarlos con el algoritmo.
    // 2. Utilizando la clase Arreglos (con elementos enteros), implemente las
    // funciones que permitan
    // determinar: a)# positivos b) # negativos, c) #pares, d)#impares e) # de
    // ceros, f)# positivos pares
    Scanner entradaArreglo = new Scanner(System.in);
    int miArreglo[];

    TareaArreglos() {

        System.out.print("Introduzca el tamaño de su arreglo: ");
        int capacidad = entradaArreglo.nextInt();
        this.miArreglo = new int[capacidad];

        System.out.println("\n" + "Introduzca los elementos del arreglo.");
        for (int i = 0; i < this.miArreglo.length; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            this.miArreglo[i] = entradaArreglo.nextInt();
        }
    }

    TareaArreglos(int tamaño) {
        Scanner entradaArreglo = new Scanner(System.in);
        this.miArreglo = new int[tamaño];
        System.out.println("\n" + "Introduzca los elementos del arreglo.");

        for (int i = 0; i < this.miArreglo.length; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            this.miArreglo[i] = entradaArreglo.nextInt();
        }
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

    public static String[] stringSort(String[] a) {
        String[] arregloStrings = a;
        int min;
        String temp;
        for (int i = 0; i < (arregloStrings.length - 1); i++) {
            min = i;

            for (int j = i + 1; j < arregloStrings.length; j++) {
                if (arregloStrings[j].compareTo(arregloStrings[min]) < 0) {
                    min = j;
                }
            }

            temp = arregloStrings[min];
            arregloStrings[min] = arregloStrings[i];
            arregloStrings[i] = temp;
        }
        return arregloStrings;
    }

    public static String fileReader(String source) {
        try {
            File myFile = new File(source);
            Scanner fileScanner = new Scanner(myFile);
            String data = fileScanner.nextLine();
            fileScanner.close();
            return data;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }
    }

    public static int[] string2IntArray(String lista) {
        StringTokenizer myST = new StringTokenizer(lista);
        int[] arregloNumeros = new int[myST.countTokens()];
        for (int i = 0; i < arregloNumeros.length; i++) {
            try {
                arregloNumeros[i] = Integer.valueOf(myST.nextToken());
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
        return arregloNumeros;
    }

    @Override
    public String toString() {
        if (miArreglo.length > 0) {
            String result = new String("{" + this.miArreglo[0]);
            for (int i = 1; i < this.miArreglo.length; i++) {
                result = result.concat("," + this.miArreglo[i]);
            }
            result = result.concat("}");
            return result;
        } else {
            return "Arreglo Vacio";
        }
    }

    public int[] onlyThisSign(int signo) {
        int contador = 0;
        int[] seleccionados = new int[this.miArreglo.length];
        switch (signo) {
            case 1:
                for (int i = 0; i < this.miArreglo.length; i++) {
                    if (this.miArreglo[i] > 0) {
                        seleccionados[contador] = this.miArreglo[i];
                        contador++;
                    }
                }
                break;
            case -1:
                for (int i = 0; i < this.miArreglo.length; i++) {
                    if (this.miArreglo[i] < 0) {
                        seleccionados[contador] = this.miArreglo[i];
                        contador++;
                    }
                }
                break;
            case 0:
                for (int i = 0; i < this.miArreglo.length; i++) {
                    if (this.miArreglo[i] == 0) {
                        seleccionados[contador] = this.miArreglo[i];
                        contador++;
                    }
                }
                break;
        }
        int[] resultado = new int[contador];
        for (int i = 0; i < contador; i++) {
            resultado[i] = seleccionados[i];
        }
        return resultado;
    }

    public int[] onlyEvenOrOdd(int mod) {
        int contador = 0;
        int[] seleccionados = new int[this.miArreglo.length];
        switch (mod) {
            case 1:
                for (int i = 0; i < this.miArreglo.length; i++) {
                    if (this.miArreglo[i] % 2 != 0) {
                        seleccionados[contador] = this.miArreglo[i];
                        contador++;
                    }
                }
                break;
            case 0:
                for (int i = 0; i < this.miArreglo.length; i++) {
                    if (this.miArreglo[i] % 2 == 0) {
                        seleccionados[contador] = this.miArreglo[i];
                        contador++;
                    }
                }
                break;
        }
        int[] resultado = new int[contador];
        for (int i = 0; i < contador; i++) {
            resultado[i] = seleccionados[i];
        }
        return resultado;
    }

    public static void ejercicio1(char selector) {
        switch (selector) {
            case 'a':
                // Ejercicio 1.a
                System.out.println("\n 1.a) Ordene el arreglo 4,8,6,2,5.");
                int[] a = { 4, 8, 6, 2, 5 };
                TareaArreglos ejercicio1a = new TareaArreglos(a);
                ejercicio1a.insertSort();
                System.out.println("El arreglo ordenado es: " + ejercicio1a.toString());
                break;
            case 'b':
                // Ejercicio 1.b
                System.out.println("\n 1.b) Cree un archivo de 30 números aleatorios y ordenelo.");
                String listaDeNumeros = new String(fileReader("numeros.txt"));
                int[] b = string2IntArray(listaDeNumeros);
                TareaArreglos ejercicio1b = new TareaArreglos(b);
                System.out.println("Se leyó el archivo numeros.txt y se obtuvo el siguiente arreglo:");
                System.out.println(ejercicio1b.toString());
                ejercicio1b.insertSort();
                System.out.println("El arreglo ordenado es:\n" + ejercicio1b.toString());
                break;
            case 'c':
                // Ejercicio 1.c
                System.out.println("\n 1.c) Se van a ordenar las siguientes cadenas en orden lexicográfico: ");
                String[] arregloCadenas = { "Hola", "Adios", "Gracias", "Denada", "Por Favor", "Algoritmo", "Java",
                        "Programación", "Axel", "Naomi" };
                for (int i = 0; i < arregloCadenas.length; i++) {
                    System.out.println(arregloCadenas[i]);
                }
                arregloCadenas = stringSort(arregloCadenas);
                System.out.println("\n La lista de cadenas ordenadas es: ");
                for (int i = 0; i < 10; i++) {
                    System.out.println(arregloCadenas[i]);
                }
                break;
        }
    }

    public static void ejercicio2(int selector) {
        System.out.println(
                "\n Este programa proporciona el número de elementos pares, impares, positivos, negativos, nulos (0) y positivos pares de un arreglo de "
                        + selector + " elementos. ");
        TareaArreglos entryNum = new TareaArreglos(selector);
        int[] aux;
        // Pares
        aux = entryNum.onlyEvenOrOdd(0);
        System.out.println("Se tienen " + aux.length + " numeros pares: " + new TareaArreglos(aux).toString());
        // Impares
        aux = entryNum.onlyEvenOrOdd(1);
        System.out.println("Se tienen " + aux.length + " numeros impares: " + new TareaArreglos(aux).toString());
        // Positivos
        aux = entryNum.onlyThisSign(1);
        System.out.println("Se tienen " + aux.length + " numeros positivos: " + new TareaArreglos(aux).toString());
        // Negativos
        aux = entryNum.onlyThisSign(-1);
        System.out.println("Se tienen " + aux.length + " numeros negativos: " + new TareaArreglos(aux).toString());
        // ceros
        aux = entryNum.onlyThisSign(0);
        System.out.println("Se tienen " + aux.length + " ceros.");
        // pares positivos
        aux = new TareaArreglos(entryNum.onlyEvenOrOdd(0)).onlyThisSign(1);
        System.out
                .println("Se tienen " + aux.length + " numeros pares positivos: " + new TareaArreglos(aux).toString());
    }

    public static void main(String[] arg) {
        ejercicio1('a');
        ejercicio1('b');
        ejercicio1('c');
        System.out.print("\n2) ");
        ejercicio2(5);
        ejercicio2(10);
        ejercicio2(15);
    }
}