package Principal;
import java.util.Scanner;

public class pruebaNumeroFuerte {
    public static void main(String[] args) {
        Scanner input1 = new Scanner(System.in);
        System.out.println(
                "Este programa prueba si un numero es fuerte; es decir, que la suma de sus factoriales es el numero.");
        boolean condicionInicio = true;
        int numero;
        do {
            System.out.println("Introduzca un número entero positivo:");
            numero = input1.nextInt();
            condicionInicio = (numero > 0);
            if (condicionInicio == false) {
                System.out.println("Su número está fuera de rango, intente de nuevo");
            }
        } while (condicionInicio == false);
        procesoPrueba(numero);
        input1.close();
    }

    public static void procesoPrueba(int a){
    int acumulador=0;
    int valorInicial=a;
    do{
        acumulador=acumulador+factorial(a-(10*(a/10)));
        a=a/10;
    }while (a!=0);
    if(acumulador==valorInicial){
        System.out.println("El número es fuerte.");
    }else{
        System.out.println("El número no es fuerte.");
    }
    }

    public static int factorial(int a) {
        int resultado = 1;
        for (int i = 1; i <= a; i++) {
            resultado = resultado * i;
        }
        return resultado;
    }
}
