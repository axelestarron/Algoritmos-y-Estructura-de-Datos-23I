import java.util.Scanner;

public class PatronGeneral {
    int cantidad;
    int direccion;

    PatronGeneral (){
        
    }

    public void imprimirNestrellitas(int n){
    }
}

public static void main(String[] args) {
    System.out.println("Este programa imprime estrellas en diferentes patrones.");
    int patron, repetir;
    Scanner input1 = new Scanner(System.in);

    do {
        System.out.println("Seleccione la esquina en la que quiere el patrón:");
        System.out.println("1:Superior izquierda." + "\n" + "2:Superior derecha." + "\n" + "3:Inferior izquierda."
                + "\n" + "4:Inferior derecha.");
        patron = input1.nextInt();
        imprimirPatron(patron);
        System.out.println("Si desea repetir el programa, presione 1");
        repetir = input1.nextInt();
    } while (repetir==1);

    System.out.println("Gracias por usar este programa :)");
    input1.close();
}