import java.util.Scanner;
import java.util.StringTokenizer;

public class cadenasPerronas {

//Ejercicio de comparación de palindromos
    public static void comparacionPalindromos(){
        String palindromo=new String("anitalavalatina");
        int longitud=palindromo.length();
        String palabraInvertida=new String("");
        char atrocidad;
        for (int i=1;i<=longitud;i++){
            atrocidad=palindromo.charAt(longitud-i);
            palabraInvertida=palabraInvertida.concat(Character.toString(atrocidad));
        }
        System.out.println("La palabra original es:"+palindromo);
        System.out.println("La palabra al reves es: "+palabraInvertida);
        boolean siEs=palindromo.equals(palabraInvertida);
        if(siEs==true){
            System.out.println("Si es un palindromo maifren");
        } else{
            System.out.println("No es un palindromo maifren");
        }
    }
//Ejercicio de conteo de caracteres
    public static void conteoCaracteres(String cadenaEntrada){
        int contador=0;
        char caracterContado;
        Scanner input1=new Scanner(System.in);
        System.out.println("Introduzca el caracter que quiere contar: ");
        caracterContado=input1.next().charAt(0);
    }
//Ejercicio de patrón de concatenación 
    public static void concatenacionPerrona(int n){
        String cadenota=new String();
        for (int i=1;i<=n;i++){
            if (n==1){
                cadenota=Integer.toString(i);
            }
            else{
                cadenota=cadenota.concat(Integer.toString(i)).concat(cadenota);
            }
            System.out.println(cadenota);
        }
    }
//Implementación de StringTokenizer
    public static void divisorLexico(){
        Scanner input1=new Scanner(System.in);
        System.out.println("Escriba una oración");
        String oracion=input1.nextLine();
        System.out.println("Cadena a procesar: "+oracion);
        //componentes lexicográficos
        StringTokenizer st=new StringTokenizer(oracion);
        while (st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
        input1.close();
    }

    public static void main(String[] args){
        divisorLexico();       
    }
}
