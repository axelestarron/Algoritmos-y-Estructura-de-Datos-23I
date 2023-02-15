import java.util.Scanner;
public class estrellitas {
    public static void main(String[] args){
        System.out.println("Este programa imprime estrellas en diferentes patrones.");
        int patron,repetir;
        Scanner input1=new Scanner(System.in); 

        do{
            System.out.println("Seleccione la esquina en la que quiere el patrón:");
            System.out.println("1:Superior izquierda." +"\n"+ "2:Superior derecha."+"\n"+"3:Inferior izquierda."+"\n"+"4:Inferior derecha.");
            patron=input1.nextInt();
            imprimirPatron(patron);
            System.out.println("Si desea repetir el programa, presione 1");
            repetir=input1.nextInt();
        }while(repetir==1);
        
        System.out.println("Gracias por usar este programa :)");
        input1.close();
    }

    public static void imprimirPatron(int a){
        int c1=0,c2=0,condicion=0;
        boolean checkEntrada=true;

        switch(a){
            case 1:a=1;
                c1=1;
                c2=1;
                condicion=5;
            break;
            case 2:a=2;
                c1=1;
                c2=-1;
                condicion=1;
            break;
            case 3:a=3;
                c1=-1;
                c2=1;
                condicion=1;
            break;
            case 4:a=4;
                c1=-1;
                c2=-1;
                condicion=-3;
            break;
            default:
                System.out.println("Entrada erronea");
                checkEntrada=false;
            break;
        }

        if (checkEntrada==true){
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if((c1*i+c2*j)<condicion){
                        System.out.print("*");
                    }else{
                        System.out.print("o");
                    }
                }
                System.out.print("\n");
            }
        }

    }

}
