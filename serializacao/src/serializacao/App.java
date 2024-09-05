package serializacao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {
    public static void main(String[] args) throws Exception {
        Pessoa p1 = new Pessoa("Gabrielly", 27 , "12345");

        try{
            FileOutputStream arqSer = new FileOutputStream("c:/Users/gabiz/Documents/Faculdade/4POA-noite/serializacao/src/serializacao/gaby.ser");
            ObjectOutputStream oSer = new ObjectOutputStream(arqSer);
            oSer.writeObject(p1);
            oSer.close();
            arqSer.close();

            p1.setTelefone("56789");
            
            System.out.println(p1);
            System.out.println("---------------------------------------------");

            /*Deserializando o objeto */
            FileInputStream arqDes = new FileInputStream("c:/Users/gabiz/Documents/Faculdade/4POA-noite/serializacao/src/serializacao/gaby.ser");
            ObjectInputStream oDes = new ObjectInputStream(arqDes);
            p1 = (Pessoa) oDes.readObject();
            oDes.close();
            arqDes.close();

            System.out.println("---------------------------------------------");

            /* Recuperando valores do objeto */
            System.out.println(p1);



        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        
    }
}
