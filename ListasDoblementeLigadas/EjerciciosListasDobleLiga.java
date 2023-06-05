package ListasDoblementeLigadas;

public class EjerciciosListasDobleLiga {
    static void incrementoConDerecha(ListaDobleLiga<Integer> miLista){
        NodoDL<Integer> aux=miLista.busquedaN(0);
        while(aux.getLigaDer()!=null){
            aux.setInfo(aux.getLigaDer().getInfo()+aux.getInfo());
            aux=aux.getLigaDer();
        }
        aux.setInfo(miLista.busquedaN(0).getInfo()+aux.getInfo());
    }
    public static void main(String[] arg){
        ListaDobleLiga<Integer> laMamalona=new ListaDobleLiga<Integer>();
        for(int i=1;i<6;i++){
            laMamalona.insertar(i);
        }
        laMamalona.busquedaN(0).setInfo(5);
        laMamalona.busquedaN(1).setInfo(3);
        laMamalona.busquedaN(2).setInfo(1);
        laMamalona.busquedaN(3).setInfo(8);
        laMamalona.busquedaN(4).setInfo(9);
        System.out.println(laMamalona.toString());
        incrementoConDerecha(laMamalona);
        System.out.println(laMamalona.toString());
    }
}
