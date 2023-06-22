package Arboles;

public class Manzana implements Comparable<Manzana>{
    private String variedad;
    private String color;
    private int peso;

    Manzana (String v, String c, int p){
        this.variedad=v;
        this.color=c;
        this.peso=p;
    }

    public int compareTo(Manzana otra){
        if(peso==otra.peso) return 0;
        if(peso<otra.peso) return -1;
        return 1;
    }

    public String toString(){
        return this.variedad+"\tcolor: "+this.color+"\tpeso: "+this.peso;
    }
}
