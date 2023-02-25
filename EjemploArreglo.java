import java.util.Scanner;

public class EjemploArreglo {
    int miArreglo[];

    // métodos constructores
    EjemploArreglo() {
        Scanner entradaArreglo = new Scanner(System.in);
        System.out.print("Introduzca el tamaño de su arreglo: ");
        int capacidad = entradaArreglo.nextInt();
        miArreglo = new int[capacidad];

        System.out.println("\n" + "Introduzca los elementos del arreglo.");
        for (int i = 0; i < miArreglo.length; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            miArreglo[i] = entradaArreglo.nextInt();
        }
        entradaArreglo.close();
    }

    EjemploArreglo(int tamaño) {
        Scanner entradaArreglo = new Scanner(System.in);
        miArreglo = new int[tamaño];
        System.out.println("\n" + "Introduzca los elementos del arreglo.");

        for (int i = 0; i < miArreglo.length; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            miArreglo[i] = entradaArreglo.nextInt();
        }
        entradaArreglo.close();
    }

    EjemploArreglo(int a[]) {
        this.miArreglo = a;
    }

    // métodos para los arreglos
    public int suma() {
        int result = 0;
        for (int i = 0; i < miArreglo.length; i++) {
            result = result + miArreglo[i];
        }
        return result;
    }

    public double promedio() {
        double prom = this.suma();
        prom = prom / 2;
        return prom;
    }

    public void insertSort() {
        int min, temp;
        for (int i = 0; i < (this.miArreglo.length - 1); i++) {
            min = i;

            for (int j = i + 1; j < this.miArreglo.length; j++) {
                if (this.miArreglo[j] < this.miArreglo[min]) {
                    min = j;
                }
            }

            temp = this.miArreglo[min];
            this.miArreglo[min] = this.miArreglo[i];
            this.miArreglo[i] = temp;
        }
    }

    @Override
    public String toString() {
        String result = new String("{" + this.miArreglo[0]);
        for (int i = 1; i < this.miArreglo.length; i++) {
            result = result.concat("," + this.miArreglo[i]);
        }
        result = result.concat("}");
        return result;
    }

    // maximo
    public int maximo() {
        int result = miArreglo[0];
        for (int i = 1; i < miArreglo.length; i++) {
            if (miArreglo[i] > result) {
                result = miArreglo[i];
            }
        }
        return result;
    }

    public int posMaximo() {
        int posMax = 0;
        for (int i = 1; i < miArreglo.length; i++) {
            if (miArreglo[i] > miArreglo[posMax]) {
                posMax = i;
            }
        }
        return posMax;
    }

    // minimo
    public int minimo() {
        int result = miArreglo[0];
        for (int i = 1; i < miArreglo.length; i++) {
            if (miArreglo[i] < result) {
                result = miArreglo[i];
            }
        }
        return result;
    }

    public int posMinimo() {
        int posMin = 0;
        for (int i = 1; i < miArreglo.length; i++) {
            if (miArreglo[i] < miArreglo[posMin]) {
                posMin = i;
            }
        }
        return posMin;
    }

    // valor medio
    public int valorMedio() {
        return miArreglo[miArreglo.length / 2];
    }

    public int posMedio() {
        return miArreglo.length / 2;
    }

    public float mediana(){
        float mediana=0;
        EjemploArreglo ordenado=new EjemploArreglo(this.miArreglo);
        ordenado.insertSort();
        if (ordenado.miArreglo.length%2!=0){
            mediana=ordenado.miArreglo[ordenado.posMedio()];
        }else{
            mediana=ordenado.miArreglo[ordenado.posMedio()]+ordenado.miArreglo[ordenado.posMedio()-1];
            mediana=mediana/2;
        }
        return mediana;
    }

    public void moda(){
        //int moda=0;
        int contadorDistinto=1;
        EjemploArreglo ordenado=new EjemploArreglo(this.miArreglo);
        ordenado.insertSort();
        //contador de cuantos números distintos hay
        for (int i=1;i<ordenado.miArreglo.length;i++){
            if(ordenado.miArreglo[i]!=ordenado.miArreglo[i-1]){
                contadorDistinto++;
            }
        }
        //conteo de cuantas veces aparece cada número
        int conteoNumeros[]=new int[contadorDistinto];
        int valorNumeros[]=new int[contadorDistinto];
        int actual=0;
        valorNumeros[0]=ordenado.miArreglo[0];
        conteoNumeros[0]=1;
        for (int i=1;i<ordenado.miArreglo.length;i++){
            if(ordenado.miArreglo[i]==ordenado.miArreglo[i-1]){
                ++conteoNumeros[actual];
            }else{
                ++actual;
                valorNumeros[actual]=ordenado.miArreglo[i];
                conteoNumeros[actual]=1;
            }
        }
        //imprimir las modas
        EjemploArreglo objetoConteoNumeros=new EjemploArreglo(conteoNumeros);
        for(int i=0;i<conteoNumeros.length; i++){
            if(objetoConteoNumeros.maximo()==conteoNumeros[i]){
                System.out.println(""+valorNumeros[i]);
            }
        }
    }
    // el main
    public static void main(String[] arg) {
        int a[] = {4,7,9,0,4,6,9,0,0,4,3};
        EjemploArreglo mikeWazowski = new EjemploArreglo(a);
        // System.out.println(abominacion.toString());
        // System.out.println("La suma de los elementos del arreglo es: "+
        // abominacion.suma());
        // System.out.println("El máximo de su arreglo es: "+ abominacion.maximo() + ",
        // en el indice: " + abominacion.posMaximo());
        //System.out.println("El valor medio es: " + mikeWazowski.valorMedio() + ", en el indice: " + mikeWazowski.miArreglo.length /2);
        // System.out.println("El promedio de su arreglo es: "+ abominacion.promedio());
        // mikeWazowski.insertSort();
        // System.out.println("El arreglo ordenado es: "+mikeWazowski.toString());
        System.out.println(
                "El mínimo de su arreglo es: " + mikeWazowski.minimo() + " en el índice: " + mikeWazowski.posMinimo());
        System.out.println("La mediana de su arreglo es: "+mikeWazowski.mediana()); 
        mikeWazowski.moda();       
    }
}
