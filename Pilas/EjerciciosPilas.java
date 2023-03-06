package Pilas;

public class EjerciciosPilas {
    //metodo de balanceo de parentesis en expresion aritmetica
    static boolean balanceoParentesis(String expresion){
        PilasDinamicas miPila=new PilasDinamicas();
        boolean bal=true;
        int i=0;
        while(bal && i<expresion.length()){
            if(expresion.charAt(i)=='('){
                miPila.insertar("(");
            }else if(expresion.charAt(i)==')'){
                if(miPila.tope!=null){
                    miPila.pop();
                }else{
                    bal=false;
                }
            }
            i++;
        }
        if(miPila.vacia()!=true && bal){
            bal=false;
        }
        return bal;
    }
    //metodo de conversión de bases con pilas 
    static String conversionBases(int b,int entrada){
        if(entrada<0||b<2){
            System.out.println("Error, por favor ingrese un número mayor que 0 y una base mayor a 2");
            return null;
        } else if(entrada==0){
            return "0";
        }

        int tamañoPila=0;
        int aux=entrada;
        while(aux>0){
            aux=aux/b;
            tamañoPila++;
        }
        PilasEstaticas miPila=new PilasEstaticas(tamañoPila);
        for(int i=0;i<tamañoPila;i++){
            miPila.insertar(entrada %b);
            entrada=entrada/b;
        }
        String miString=new String("");
        while(miPila.tope!=-1){
            miString+=miPila.pop();
        }
        return miString;

    }
    public static void main(String[] arg){
        //String result=new String(conversionBases(5,1073));
        //System.out.println(result);
        if(balanceoParentesis("())")){
            System.out.println("Si está balanceada su expresion");
        }else{
            System.out.println("No está balanceada");
        }
    }
}
