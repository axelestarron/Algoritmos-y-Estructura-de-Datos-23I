package Principal;
import java.util.Stack;

public class StacksChidos{
    public static void main(String[] args) {
        Stack<String> p=new Stack<String>();
        p.push("Hola");
        p.push("Adios");
        p.push("Buenas noches");
        p.push("Ya reprobé");
        while(!p.empty()){
            System.out.println(p.pop());
        }
    }
}