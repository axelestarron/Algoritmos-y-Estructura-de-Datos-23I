package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializador {
    public void serialize(String nameFile, Object object) {
        try (FileOutputStream fs = new FileOutputStream(nameFile, true);
             ObjectOutputStream os = new ObjectOutputStream(fs)) {
            os.writeObject(object);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Object deserialize(String nameFile) {
        Object object = null;
        try (FileInputStream fs = new FileInputStream(nameFile);
             ObjectInputStream os = new ObjectInputStream(fs)) {
            object = os.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return object;
    }
    
    public static void main(String[]args){
        RegistroDatos myMan=new RegistroDatos();
        Perrito xoco=new Perrito("Xoquito");
        myMan.serialize("registroperrito", xoco);
        Perrito otroPerrito=(Perrito) myMan.deserialize("registroperrito");
        System.out.println(otroPerrito.nombre);
    }
}
