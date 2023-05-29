import java.util.Scanner;
public class Lomito implements Comparable<Lomito>{
    private String nombre;
    private int edad;
    private Scanner input1=new Scanner(System.in);
//Constructor    
    public Lomito(){
        System.out.println("Escriba el nombre de su lomito: ");
        this.nombre=input1.nextLine();
        System.out.println("Escriba la edad (en años) de su lomito");
        this.edad=input1.nextInt();
    }
//Constructor con parámetros
    public Lomito(String nuevoNombre,int nuevaEdad){
        this.nombre=nuevoNombre;
        this.edad=nuevaEdad;
    }    
//Comparador
    @Override
    public int compareTo(Lomito nacho){
        if(this.edad>nacho.edad){
            return 1;
        }else if(this.edad<nacho.edad){
            return -1;
        }else{
            return this.nombre.compareTo(nacho.nombre);
        }
    }
//Prueba igual
    public boolean equals(Lomito nacho){
        return this.compareTo(nacho)==0;
    }
//toString
    @Override
    public String toString(){
        return "Lomito[Nombre: "+this.nombre+"; Edad: "+this.edad+"]";
    }
    public static void main(String[] arg){
        Lomito Naui=new Lomito("Naui",5);
        System.out.println(Naui.toString());
        Lomito Xoco=new Lomito("Xoco",1);
        System.out.println(Xoco.toString());
        if(Naui.compareTo(Xoco)>0){
            System.out.println(Naui.nombre +" es mas grande que "+Xoco.nombre);
        }else{
            System.out.println(Naui.nombre +" es mas pequeña que "+Xoco.nombre);
        }
    }
}
