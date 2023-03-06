package Tareas;

public class TareaComplejos {
    public double re;
    public double im;
    //Empty constructor
    public TareaComplejos(){
        re=0;
        im=0;
    }
    //Constructor with parameters
    public TareaComplejos(double a, double b){
        re=a;
        im=b;
    }
    //Add method
    TareaComplejos suma(TareaComplejos sumando){
        TareaComplejos resultado=new TareaComplejos();
        resultado.re=this.re+sumando.re;
        resultado.im=this.im+sumando.im;
        return resultado;
    }
    //Subtract method
    TareaComplejos resta(TareaComplejos restando){
        TareaComplejos resultado=new TareaComplejos();
        resultado.re=this.re-restando.re;
        resultado.im=this.im-restando.im;
        return resultado;
    }
    //Product method
    TareaComplejos producto(TareaComplejos factor){
        TareaComplejos resultado=new TareaComplejos();
        resultado.re=(this.re*factor.re)-(this.im*factor.im);
        resultado.im=(this.re*factor.im)+(this.im*factor.re);
        return resultado;
    }
    //Squared magnitude method
    double magnitud(){
        return this.re*this.re + this.im*this.im;
    }
    //complement methodo
    TareaComplejos complemento(){
        TareaComplejos resultado=new TareaComplejos();
        resultado.re=this.re;
        resultado.im=-this.im;
        return resultado;
    }
    //Division method
    TareaComplejos division(TareaComplejos divisor){
        if(divisor.re==0 && divisor.im==0){
            System.out.println("Error, no se puede dividir un número entre 0");
            return null;
        }else{
            TareaComplejos resultado=new TareaComplejos();
            resultado=this.producto(divisor.complemento());
            resultado.re=resultado.re/divisor.magnitud();
            resultado.im=resultado.im/divisor.magnitud();
            return resultado;
        }
    }
    //Utility methods
    //toString
    @Override
    public String toString(){
        return "("+this.re+")"+"+ ("+this.im+")i";
    }

    boolean equals(TareaComplejos comparado){
        return this.re==comparado.re && this.im==comparado.im;
    }

    int compareTo(TareaComplejos comparado){
        if(this.equals(comparado)){
            return 0;
        }else if(this.magnitud()>comparado.magnitud()){
            return 1;
        }else{
            return -1;
        }
    }

    public static void main(String[]arg){
        TareaComplejos a=new TareaComplejos(2,3);
        TareaComplejos b=new TareaComplejos(3,4);
        System.out.println(a.division(b).toString());

    }
}
