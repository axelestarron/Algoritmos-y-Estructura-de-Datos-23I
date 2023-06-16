package Principal;
public class Recursividad{
//Factorial
    static int factorial(int n){
        //Este metodo calcula el factorial utilizando la definicion: n!=n*(n-1)!
        //El caso base es 0!=1
        if(n==0) return 1;
        return n*factorial(n-1);
    }
//Fibonacci
    static int fibonacci(int n){
        //Metodo para calcular el n-esimo termino de la serie fibonacci, dada la
        //definicion f(n)=f(n-1)+f(n-1).
        //Los casos base son f(1)=0, f(2)=1, tomando la definicion de la serie:
        //0,1,1,2,3,5,8,13...
        if(n==1) return 0;
        if(n==2) return 1;
        return fibonacci(n-1)+ fibonacci(n-2);
    }
//Potencia de un numero
    static int potencia(int n,int x){
        //Se obtiene la potencia x^n sabiendo que: x^n=x*x^(n-1).
        if(n==0) return 1;
        return x*potencia(n-1,x);
    }
//maximo comun divisor
    static int mcd(int p, int q){
        //Este metodo utiliza el algoritmo de euclides, que establece que:
        //"Dados dos numeros a y b, donde a>b, entonces el maximo comun divisor 
        //de a y b es el maximo comun divisor de by el residuo de a/b".
        int a,b;
        if(p>q){
            a=p;
            b=q;
        }else{
            a=q;
            b=p;
        }
        if(b==0){
            return a;
        }
        return mcd(b, a%b);
    }
//Busqueda binaria
    static int busBin(int l, int r, int a, int[] arreglo){
        //La busqueda binaria parte la lista en mitades para encontrar el indice del elemento.
        //Primero busca a la mitad de la lista, despues la parte en dos y realiza
        //el mismo proceso en cada sublista.
        //Si el elemento no se encuentra, regresa -1.
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
        //Metodo para unir dos arreglos ordenados arr1 y arr2 a un solo arreglo a.
        //Aqui, lim1 y lim2 son la cantidad de elementos de arr1 y arr2 que se van
        //a integrar a la lista a.
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
        //Metodo para ordenar un arreglo al dividirlo en 2, ordenar las dos
        //mitades y unirlas en un solo arreglo. Las dos mitades se ordenan con el
        //mismo algoritmo y se aplica recursivamente hasta llegar a arreglos de 1 elemento.
        //Este algoritmo requiere del metodo merge.
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
                System.out.print("{"+a[i]);
            }else{
                System.out.print(", "+a[i]);
            }
        }
        System.out.println("}");
    }
    public static void main(String[] arg){
        //Ejemplo factoriales:
        System.out.println("\n a. Factorial de un numero:");
        System.out.println("\t 3!="+ factorial(3));
        System.out.println("\t 7!"+ factorial(7));
        System.out.println("\t 10!"+ factorial(10)+"\n");
        //Ejemplo fibonacci
        System.out.println("b. Secuencia fibonacci (primeros 10 términos):");
        for(int i=1;i<=11;i++){
            if(i==1){ 
                System.out.print("\t"+fibonacci(i));
            }else if(i<11&&i!=1){
                System.out.print(", "+fibonacci(i));
            }else{
                System.out.println("\n");
            }
        }
        //Ejemplo potencias
        System.out.println("c. Potencia de un numero:");
        System.out.println("\t 2^10="+potencia(10,2));
        System.out.println("\t 8^3="+potencia(3,8));
        System.out.println("\t 14^2="+potencia(2,14));
        //Ejemplo maximo comun divisor
        System.out.println("\n d. Maximo comun divisor de dos numeros:");
        System.out.println("\t 24 y 36: "+mcd(24,36));
        System.out.println("\t 28 y 84: "+mcd(28,84));
        System.out.println("\t 56 y 72: "+mcd(56,72));
        //Ejemplo busqueda binaria
        System.out.println("\n e.Busqueda binaria: ");
        System.out.print("\t Busca el indice de 2, 8 y 15 en el arreglo:");
        int[] miArreglo={2,4,5,6,8,9,11,14,16};
        imprimeArreglo(miArreglo);
        System.out.println("\t arreglo["+busBin(0, miArreglo.length, 2, miArreglo)+"]=2");
        System.out.println("\t arreglo["+busBin(0, miArreglo.length, 8, miArreglo)+"]=8");
        System.out.println("\t arreglo["+busBin(0, miArreglo.length, 15, miArreglo)+"]=15 (no se encuentra)");
        //Ejemplo mergesort
        System.out.println("\n f. Mergesort:");
        System.out.print("\t Primer arreglo desordenado: ");
        int[] primerArreglo={12,10,11,15,4,2,3,7};
        imprimeArreglo(primerArreglo);
        mergeSort(primerArreglo);
        System.out.print("\t Primer arreglo ordenado: ");
        imprimeArreglo(primerArreglo);
        System.out.print("\t Segundo arreglo desordenado: ");
        int[] segundoArreglo={4,5,2,3,0,1};
        imprimeArreglo(segundoArreglo);
        mergeSort(segundoArreglo);
        System.out.print("\t Segundo arreglo ordenado: ");
        imprimeArreglo(segundoArreglo);
        System.out.print("\t Tercer arreglo desordenado: ");
        int[] tercerArreglo={100,99,98,97,96,95,94,93,92,91,90};
        imprimeArreglo(tercerArreglo);
        mergeSort(tercerArreglo);
        System.out.print("\t Tercer arreglo ordenado: ");
        imprimeArreglo(tercerArreglo);
    }
}