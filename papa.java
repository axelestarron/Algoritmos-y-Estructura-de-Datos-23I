import java.util.Scanner;

public class papa{
    public static void main(String[] args){
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        int a = input1.nextInt();
        int b= input2.nextInt();
        input1.close();
        input2.close();
        comparacion(a, b);
        }

    public static void comparacion(int a, int b){
        if (a>b){
            System.out.println("El numero mayor es:" +a);
        } else if (a==b) {
            System.out.println("El numero " +a+" el número "+b+" son iguales.");
        } else {
            System.out.println("El numero mayor es:" +b);
        }
    }
}