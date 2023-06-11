package Principal;
public class Recursividad{
//Factorial
    static int factorial(int n){
        if(n==0) return 1;
        return n*factorial(n-1);
    }
//Fibonacci
    static int fibonacci(int n){
        if(n==1) return 0;
        if(n==2) return 1;
        return fibonacci(n-1)+ fibonacci(n-2);
    }
//Potencia de un numero
    static int potencia(int n,int x){
        if(n==0) return 1;
        return x*potencia(n-1,x);
    }
//Busqueda binaria
    static int busBin(int l, int r, int a, int[] arreglo){
        int m=(l+r)/2;
        if(arreglo[m]==a) return m;
        if(l>=r) return -1;
        if(a>arreglo[m]){
            return busBin(m+1,r,a,arreglo);
        }else{
            return busBin(l,m-1,a,arreglo);
        }
    }
//Merge
    static void merge(int[]a,int[]arr1,int[]arr2,int lim1,int lim2){
        int i=0; int j=0; int k=0;
        while(i<lim1 && j<lim2){
            if(arr1[i]<arr2[j]){
                a[k++]=arr1[i++];
            }else{
                a[k++]=arr2[j++];
            }
        }
        while(i<lim1){
            a[k++]=arr1[i++];
        }
        while(j<lim2){
            a[k++]=arr2[j++];
        }
    }
//Merge Sort
    static void mergeSort(int[] desordenado){
        if(desordenado.length>1){
            int m=desordenado.length/2;
            int[] copia1=new int[m];
            for(int i=0;i<copia1.length;i++){
                copia1[i]=desordenado[i];
            }
            int[] copia2=new int[desordenado.length-m];
            for(int i=0;i<copia2.length;i++){
                copia2[i]=desordenado[m+i];
            }
            mergeSort(copia1);
            mergeSort(copia2);
            merge(desordenado,copia1,copia2,m,desordenado.length-m);
        }    
    }
//imprimir arreglos
    static void imprimeArreglo(int[]a){
        for(int i=0;i<a.length;i++){
            if(i==0){
                System.out.print(a[i]);
            }else{
                System.out.print(", "+a[i]);
            }
        }
        System.out.println("");
    }

//Suma de arreglos
    static int sumaArreglo(int[] a,int n){
        if(n<=0) return 0;
        return sumaArreglo(a, n-1)+a[n-1];
    }
    public static void main(String[] arg){
        System.out.println("El factorial de 10 es: "+ factorial(10));
        System.out.println("Los primeros 10 términos de la secuencia fibonacci son: ");
        for(int i=1;i<=11;i++){
            if(i==1){ 
                System.out.print(fibonacci(i));
            }else if(i<11&&i!=1){
                System.out.print(", "+fibonacci(i));
            }else{
                System.out.println("");
            }
        }
        System.out.println("La decima potencia de 2 es: "+potencia(10,2));
        int[] miArreglo={2,4,5,6,8,9,11,14,16};
        int[] otroArreglo={3,7,10,12,13,15,17,18};
        int[] nuevoArreglo=new int[miArreglo.length+otroArreglo.length];
        merge(nuevoArreglo,miArreglo,otroArreglo,miArreglo.length,otroArreglo.length);
        imprimeArreglo(nuevoArreglo);
        int[] arregloFeo={7,23,19,24,4,9,20,18,2};
        imprimeArreglo(arregloFeo);
        mergeSort(arregloFeo);
        imprimeArreglo(arregloFeo);
    }
}