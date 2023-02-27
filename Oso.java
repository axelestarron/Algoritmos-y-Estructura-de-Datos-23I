import java.util.Scanner;

public class Oso{
    String nombre;
    String especie; 
    int edad;

    public Oso(){
        Scanner input1=new Scanner(System.in);
        System.out.println("Escriba el nombre del oso: ");
        this.nombre=input1.nextLine();
        System.out.println("Escriba la especie del oso: ");
        this.especie=input1.nextLine();
        System.out.println("Escriba la edad del oso: ");
        this.edad=input1.nextInt();
        input1.close();
    }

    public Oso(String nomIn, String espIn,int edadIn){
        this.nombre=nomIn;
        this.especie=espIn;
        this.edad=edadIn; 
    }

    @Override
    public String toString(){
        return "Oso [nombre: " +this.nombre+", especie: "+this.especie+", edad: "+this.edad+"]"; 
    }

    public String getEspecie(){
        return this.especie;
    }

    public void setEspecie(String espNew){
        this.especie=espNew;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nomNew){
        this.nombre=nomNew;
    }

    public int getEdad(){
        return this.edad;
    }

    public void setEdad(int edadNew){
        this.edad=edadNew;
    }

}