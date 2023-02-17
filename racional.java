import java.util.Scanner;

public class racional{
    int num;
    int den;
    //constructor default sin argumentos
    public racional(){
        this.num=1;
        this.den=1;
    }
    //constructor con parametros
    public racional(int a,int b){
        this.num=a;
        this.den=b;
    }

    public racional suma(racional R){
        racional result=new racional();
        result.num= num*R.den + den*R.num;
        result.den=den*R.den;
        return result;
    }
    @Override
    public String toString(){
        return num+"/"+den;
    }

    public static racional resta(racional a, racional b){
        racional result=new racional();
        result.num=a.num*b.den-b.num*a.den;
        result.den=a.den*b.den;
        return result;
    }

    public static void main(String[] args) {
        Scanner input1=new Scanner(System.in);

        racional fraccionPrueba=new racional();

        System.out.println("Prueba de suma.");
        System.out.print("Numerador:");
        
        fraccionPrueba.num=input1.nextInt();
        System.out.print("\n Denominador:");
        fraccionPrueba.den=input1.nextInt();
        System.out.print("\n");
        racional fraccionSumada=new racional(1,2);
        racional result=fraccionPrueba.suma(fraccionSumada);
        System.out.println(result.toString());
        input1.close();
    }
}  

