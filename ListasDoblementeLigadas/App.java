package ListasDoblementeLigadas;
public class App {
    public static void main(String[] args){
        //polinomio con diferentes coeficientes y exponentes
        int[]a={2,3,1,5,7,6,10};
        float[]b={1,-4,2.5f,7.6f,11.6f,-0.6f,3.14f};
        ListaDobleLiga<Termino> polinomio1=new ListaDobleLiga<Termino>();
        for(int i=0;i<7;i++){
            polinomio1.insertar(new Termino(b[i],a[i]));
        }
        System.out.println("Primer polinomio a sumar: "+polinomio1.toString());
        int[]c={2,5,4,7,8,10,11,15};
        float[]d={1,2,3,-3,-2,-1,0.4f,2.15f};
        ListaDobleLiga<Termino> polinomio2=new ListaDobleLiga<Termino>();
        for(int i=0;i<7;i++){
            polinomio2.insertar(new Termino(d[i],c[i]));
        }
        System.out.println("Segundo polinomio a sumar: "+polinomio2.toString());
        ListaDobleLiga<Termino> sumaPolinomio12=Termino.sumaPolinomios(polinomio1,polinomio2);
        System.out.println("Resultado de la suma: "+sumaPolinomio12.toString());
    }
}
