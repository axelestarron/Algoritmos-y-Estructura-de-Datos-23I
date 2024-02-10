package modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CVmanager {
    private CVpersona miPersona;
    private Serializador miSerializador=new Serializador();
    
    public CVmanager(){
    }

    //Asigna la persona asociada al CVmanager
    public void setPersona(CVpersona nuevaPersona){
        this.miPersona=nuevaPersona.copyCVpersona();
    }

    public CVpersona getPersona(){
        return this.miPersona;
    }

    //guarda en un archivo la persona que tiene asociada el CVmanager
    public void saveUser() throws IOException{
        if(miPersona!=null){
            if(this.isThereUser(miPersona.getUsername())){
                this.deleteUser(miPersona.getUsername());
            }
            miSerializador.serialize(this.miPersona.getUsername(),this.miPersona);
        }
    }

    //carga de un archivo a una persona por medio del userName
    public void loadUser(String userName){
        if(isThereUser(userName)){
            this.miPersona=(CVpersona) miSerializador.deserialize(userName);
            System.out.println("Registro "+userName+" cargado exitosamente");
        }else{
            System.out.println("Error al cargar persona");
        }
    }

    //elimina a una persona a partir de su nombre de usuario
    public void deleteUser(String userName) throws IOException{
        if(isThereUser(userName)){
            Files.deleteIfExists(Paths.get(userName));
            System.out.println("Registro "+userName+" eliminado exitosamente");
        }else{
            System.out.println("Error, el registro no existe");
        }
    }

    //permite determinar si el usuario existe o no
    public boolean isThereUser(String userName){
        return Files.exists(Paths.get(userName));
    }


    public static void main(String[]args) throws IOException{
        CVmanager mikeWazowski=new CVmanager();
        mikeWazowski.loadUser("AxelEstNav");
        System.out.println(mikeWazowski.getPersona().getIdiomas().get(0).getIdioma());
        CVpersona temp=mikeWazowski.getPersona().copyCVpersona();
        temp.addIdi(new Idiomas("Aleman","experto"));
        temp.modifyIdi(0, new Idiomas("Arabe","chido"));
        mikeWazowski.setPersona(temp);
        mikeWazowski.saveUser();
        mikeWazowski.loadUser("AxelEstNav");
        System.out.println(mikeWazowski.getPersona().getIdiomas().get(0).getIdioma());
        System.out.println(mikeWazowski.getPersona().getIdiomas().get(1).getIdioma());
    }


}
