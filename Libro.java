import java.util.Scanner;
public class Libro{
    String titulo;
    String autor;
    int clave;

    Libro(){
        Scanner input1=new Scanner(System.in);
        System.out.println("Va a crear un objeto de la clase Libro. Escriba el titulo de su libro: ");
        titulo=input1.nextLine();
        System.out.println("Escriba el autor de su libro: ");
        autor=input1.nextLine();
        System.out.println("Escriba la clave de su libro: ");
        clave=input1.nextInt();
        input1.close();
    }



    public static void main(String[] args){
        Libro miLibro=new Libro();
        System.out.println("La clave del libro es: "+ miLibro.clave);
    }
}