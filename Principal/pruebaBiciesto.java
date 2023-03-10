package Principal;
import java.util.Scanner;
public class pruebaBiciesto {
    public static void main(String[] args){
        Scanner input1=new Scanner(System.in);
        System.out.println("Este programa determina si un año despues de 1582 es bisiesto.");
        int fecha;
        boolean checkFecha; 
        do{
        System.out.println("Por favor, introduzca un año válido");
        fecha=input1.nextInt();
        checkFecha=fecha>1582;
            if (checkFecha==false){
                System.out.println("Fecha no valida.");
            }
        }while(checkFecha==false);
        //metodo para checar si la fecha es año bisiesto
        pruebaFechaBisiesto(fecha);
        input1.close();        
    }
    
    public static void pruebaFechaBisiesto(int a){
        if (a%4==0 && a%100!=0){
            System.out.println("El año "+a+" es bisiesto");
        }else if(a%400==0){
            System.out.println("El año "+a+" es bisiesto");
        }else{
            System.out.println("El año "+a+" no es bisiesto");
        }
    }
}
