import java.util.Scanner;

public class multiplos5Rango{
    public static void main(String[] args){
    Scanner input1=new Scanner(System.in);
    Scanner input2=new Scanner(System.in);
    int limiteInferior=input1.nextInt();
    int limiteSuperior=input2.nextInt();
    listaMultiplosDe5(limiteInferior, limiteSuperior);
    input1.close();
    input2.close();
    //aqui va a ir el metodo de imprimir los números
    listaMultiplosDe5(limiteInferior, limiteSuperior);
    }
    
    public static void listaMultiplosDe5(int limiteInferior,int limiteSuperior){
    //aqui debe de ir la comparación    
    int primerMultiplo=5*(limiteInferior/5);
    int ultimoMultiplo=5*(limiteSuperior/5);
    int resultado;
    if (primerMultiplo!=limiteInferior){
        resultado=primerMultiplo+5;
    }else{
        resultado=primerMultiplo;
    }
    System.out.println("La lista de multiplos es:");
while(resultado<=ultimoMultiplo){
    System.out.println(resultado);
    resultado=resultado+5;
    }
    } 
}

