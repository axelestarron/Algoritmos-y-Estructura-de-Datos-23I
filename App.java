public class App {
    public static void main(String[] args) {
        //System.out.println("Hello, World!");
        
        Oso miOso=new Oso("Maikol Yakson","Ayuwoki",53);
        Oso otroOso=new Oso("Alfredo Mercurios","Mama Uuuu",47);
        Oso tercerOso=new Oso("Kurko Bein","Grungy",27);
        racional fraccion=new racional(3,4);
        Object[] arregloTuneado=new Object[4];
        arregloTuneado[0]=miOso;
        arregloTuneado[1]=otroOso;
        arregloTuneado[2]=tercerOso;
        arregloTuneado[3]=fraccion;

        for(Object i:arregloTuneado){
            System.out.println(i.toString());
        }
    }
}
