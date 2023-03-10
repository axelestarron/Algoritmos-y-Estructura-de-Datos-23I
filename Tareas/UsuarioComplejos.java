package Tareas;

import java.util.Scanner;

public class UsuarioComplejos {

    public static TareaComplejos operaciones(int a, TareaComplejos X, TareaComplejos Y) {
        switch (a) {
            case 1:
                return X.suma(Y);
            case 2:
                return X.resta(Y);
            case 3:
                return X.producto(Y);
            case 4:
                return X.division(Y);
            default:
                System.out.println("Por favor, seleccione una opcion valida");
                return null;
        }
    }

    public static void main(String[] arg) {
        TareaComplejos complejo1 = new TareaComplejos();
        TareaComplejos complejo2 = complejo1.copyOfTareaComplejos();
        Scanner input1 = new Scanner(System.in);
        int opcionOperacion, opcionContinuar;
        int opcionRepValores = 0;
        double aux;
        System.out.println("\n Este programa realiza operaciones con dos números complejos.");
        do {
            System.out.println(
                    "Selecione una de las siguientes opciones: \n 1. Sumar. \n 2. Restar. \n 3. Multiplicar. \n 4. Dividir.");
            opcionOperacion = input1.nextInt();
            if (opcionRepValores != 1) {
                // Lectura del primer número complejo
                System.out.println("Introduzca la parte real e imaginaria del primer número:");
                System.out.print("Re: ");
                aux = input1.nextDouble();
                complejo1.setReal(aux);
                System.out.print("Im: ");
                aux = input1.nextDouble();
                complejo1.setImaginary(aux);
                // Lectura del segundo número complejo
                System.out.println("Introduzca la parte real e imaginaria del segundo número: ");
                System.out.print("Re: ");
                aux = input1.nextDouble();
                complejo2.setReal(aux);
                System.out.print("Im: ");
                aux = input1.nextDouble();
                complejo2.setImaginary(aux);
            }

            System.out.println("El resultado de la operación es: "
                    + operaciones(opcionOperacion, complejo1, complejo2).toString());
            System.out.println("Si desea utilizar el programa nuevamente, presione 1; sino, presione otra tecla.");
            opcionContinuar = input1.nextInt();
            if (opcionContinuar == 1) {
                System.out.println(
                        "Si desea utilizar los mismos numeros complejos, presione 1; sino, presione otra tecla.");
                opcionRepValores = input1.nextInt();
            }
        } while (opcionContinuar == 1);

        System.out.println("Gracias por utilizar el programa :)");
        input1.close();
    }
}
