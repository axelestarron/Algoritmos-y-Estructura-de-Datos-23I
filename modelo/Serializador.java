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
        Serializador myMan=new Serializador();
        DatosGrales miDG=new DatosGrales("Axel", "Est", "Nav", 7, 2, 2000, "Tepic", "Mexico");
        DatosAcad miDA=new DatosAcad("Preparatoria", "UAM", 1, 2025, 1, 2027, "CDMX", "Mexico");
        DatosLabo miDL=new DatosLabo("Unilever","Intern",1,2020,1,2024,"Tultitlan","Mexico");
        Habilidades miHa=new Habilidades("Lectura", "Leer prron", "Avanzado");
        Idiomas miIdi=new Idiomas("Ingles", "Experto");
        CVpersona personaPrueba=new CVpersona(miDG, miDA, miDL, miHa, miIdi);
        personaPrueba.addLabo(new DatosLabo("Didi","Jefe",1,2020,1,2024,"Tultitlan","Mexico"));
        myMan.serialize(personaPrueba.getUsername(), personaPrueba);
        //CVpersona otraPersona=(CVpersona) myMan.deserialize("AxelEstNav");
        //System.out.println(otraPersona.getDatosLabo().get(1).getInstit());
    }
}
