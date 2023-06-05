public class Recursividad{
//Suma de arreglos
    static int sumaArreglo(int[] a,int n){
        if(n<=0) return 0;
        return sumaArreglo(a, n-1)+a[n-1];
    }
    public static void main(String[] arg){
        int[] miArreglo={7,8,9,10};
        System.out.println("La suma de mi arreglo es: "+ sumaArreglo(miArreglo,miArreglo.length));
    }
}