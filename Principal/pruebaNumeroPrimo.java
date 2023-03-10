package Principal;
import java.util.Scanner;

public class pruebaNumeroPrimo{
    public static void main(String[] args){
       //inicialización de variables y scanner para el programa principal
        boolean entradaCorrecta=true;
        System.out.println("Este programa determina si un número entre el 1 y el 100 es primo.");
        Scanner input1=new Scanner(System.in);
        int candidatoPrimo;
       //Escaneo del número de entrada, si el resultado está fuera de rango, se escanea nuevamente.
        do{
            System.out.println("Introduzca el número que quiere analizar:");
            candidatoPrimo=input1.nextInt();
            entradaCorrecta=(candidatoPrimo>=1 && candidatoPrimo<=100);
            if (entradaCorrecta==false){
                System.out.println("Por favor, introduzca un número del 1 al 100.");
            }
        }while(entradaCorrecta==false);
        //Uso del método para probar si la entrada es un número primo
        procesoPrueba(candidatoPrimo);
        input1.close();
    }
    //declaración del método para probar si la entrada es un primo
    public static void procesoPrueba(int a){
        //lista de números primos del 1-100
        int listaPrimos[]=new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        boolean valorPrueba=true; //condición para el ciclo while
        int restoDivisionPrima;   
        int contador=0;           //contador para el ciclo while
        while (valorPrueba==true && contador<25) {
            restoDivisionPrima=a%listaPrimos[contador];
                if (restoDivisionPrima==0 && a!=0){
                    System.out.println("El número "+a+" no es primo.");
                    valorPrueba=false;
                } else if (a==listaPrimos[contador]){
                    System.out.println("El número "+a+" si es primo.");
                    valorPrueba=false;
                }
            contador++;
        }
    }
}
