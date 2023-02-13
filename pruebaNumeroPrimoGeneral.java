import java.util.Scanner;

public class pruebaNumeroPrimoGeneral{
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
            entradaCorrecta=(candidatoPrimo>0);
            if (entradaCorrecta==false){
                System.out.println("Por favor, introduzca un número entero positivo.");
            }
        }while(entradaCorrecta==false);
        //Uso del método para probar si la entrada es un número primo
        procesoPrueba(candidatoPrimo);
        input1.close();
    }
    //declaración del método para probar si la entrada es un primo
    public static void procesoPrueba(int a){
        boolean valorPrueba=true; //condición para el ciclo while
        int restoDivisionPrima;   
        int contador=2;           //contador para el ciclo while
        switch (a){
            case 1: a=1;
            System.out.println("El número que escribió es la unidad, por lo que no es primo.");
            break;
            default: 
                valorPrueba=false;
                while (valorPrueba==false && contador<=a){
                    valorPrueba=a%contador==0;
                    if (a==contador){
                        System.out.print("El número es primo");
                        break;
                    } else if(valorPrueba==true){
                        System.out.println("El número no es primo.");
                        break;
                    }
                    contador++;
                }

        }
    }
}