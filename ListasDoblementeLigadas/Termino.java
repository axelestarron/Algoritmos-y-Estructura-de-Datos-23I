package ListasDoblementeLigadas;

public class Termino implements Comparable<Termino> {
    int exponente; //el grado del término del polinomio Cx^n
    float coeficiente; //el coeficiente del termino del polinomio Cx^n
//Constructor
    Termino(){
        this.exponente=0;
        this.coeficiente=0;
    }
//Constructor con parámetros
    Termino(float C, int n){
        this.exponente=n;
        this.coeficiente=C;
    }
 //compareTo
    @Override
    public int compareTo(Termino P){
        //El metodo compareTo compara dos terminos en funcion de su grado (x^n)
        //En dado caso de que tengan el mismo grado, se comparan los coeficientes
        if(this.exponente>P.exponente){
            return 1;
        }else if(this.exponente<P.exponente){
            return -1;
        }else{
            if(this.coeficiente>P.coeficiente){
                return 1;
            }else if(this.coeficiente<P.coeficiente){
                return -1;
            }else{
                return 0;
            }
        }
    }
//comparador de exponentes
    public boolean exponenteIgual(Termino P){
        return this.exponente==P.exponente;
    }
//Metodo para la tarea de suma de polinomios
    public static ListaDobleLiga<Termino> sumaPolinomios(ListaDobleLiga<Termino> Poli1,ListaDobleLiga<Termino> Poli2){
        NodoDL<Termino> aux1=Poli1.cabeza;
        NodoDL<Termino> aux2=Poli2.cabeza;
        ListaDobleLiga<Termino> sumaPoli=new ListaDobleLiga<Termino>();
        while(aux1!=null && aux2!=null){
            if(aux1.getInfo().exponenteIgual(aux2.getInfo())){
                sumaPoli.insertar(new Termino(aux1.getInfo().coeficiente+aux2.getInfo().coeficiente, aux1.getInfo().exponente));
                aux1=aux1.getLigaDer();
                aux2=aux2.getLigaDer();
            }else if(aux1.getInfo().compareTo(aux2.getInfo())>0){
                sumaPoli.insertar(aux2.getInfo());
                aux2=aux2.getLigaDer();
            }else{
                sumaPoli.insertar(aux1.getInfo());
                aux1=aux1.getLigaDer();
            }
        }
        while(aux1!=null && aux2==null){
            sumaPoli.insertar(aux1.getInfo());
            aux1=aux1.getLigaDer();
        }
        while(aux1==null && aux2!=null){
            sumaPoli.insertar(aux2.getInfo());
            aux2=aux2.getLigaDer();
        }
        return sumaPoli;
    }
//toString
    @Override
    public String toString(){
        return this.coeficiente+"x^"+this.exponente;
    }
//Metodos para el ejercicio de tarea
//Main
    public static void main(String[] args){
        ListaDobleLiga<Termino> polinomio1=new ListaDobleLiga<Termino>();
        for(int i=1;i<6;i++){
            polinomio1.insertar(new Termino(i,i));
        }
        ListaDobleLiga<Termino> polinomio2=new ListaDobleLiga<Termino>();
        int[] a={3,4,6,2,1};
        for(int i=2;i<7;i++){
            polinomio2.insertar(new Termino(a[i-2],i));
        }
        System.out.println(polinomio1.toString());
        System.out.println(polinomio2.toString());
        ListaDobleLiga<Termino> sumaPoli12=sumaPolinomios(polinomio1, polinomio2);
        System.out.println(sumaPoli12.toString());
    }
}
