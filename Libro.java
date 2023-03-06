import java.util.Scanner;
import java.util.StringTokenizer;
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

    Libro(Object o){
        String cadena=(String)o;
        StringTokenizer st=new StringTokenizer(cadena,",");
        titulo=st.nextToken();
        autor=st.nextToken();
        clave=Integer.valueOf(st.nextToken().trim());
    }

    Libro(String entryTitulo, String entryAutor, int entryClave){
        titulo=entryTitulo;
        autor=entryAutor;
        clave=entryClave;
    }

    public Object clone(){
        return new Libro(this.titulo,this.autor,this.clave);
    }

    @Override
    public String toString(){
        return "Titulo: " +this.titulo+" Autor: "+this.autor+" Clave: "+this.clave;
    }

    public boolean equals(Object o){
        if(o==null) return false;
        if(o==this) return true;
        if(this.getClass()!=o.getClass()) return false;
        return false;
    }



    public static void main(String[] args){
        Libro miLibro=new Libro();
        System.out.println("La clave del libro es: "+ miLibro.clave);
    }
}