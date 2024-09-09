package serializacao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {
    public static void main(String[] args) throws Exception {
        Professor prof1 = new Professor("Gabrielly", "gabrielly@example.com", "Matemática");

        try {
            FileOutputStream arqSer = new FileOutputStream("c:/Users/gabiz/Documents/Faculdade/4POA-noite/serializacao/src/serializacao/professor.ser");
            ObjectOutputStream oSer = new ObjectOutputStream(arqSer);
            oSer.writeObject(prof1);
            oSer.close();
            arqSer.close();

            prof1.setMateria("Física");
            
            System.out.println(prof1);
            System.out.println("---------------------------------------------");

            /* Deserializando o objeto */
            FileInputStream arqDes = new FileInputStream("c:/Users/gabiz/Documents/Faculdade/4POA-noite/serializacao/src/serializacao/professor.ser");
            ObjectInputStream oDes = new ObjectInputStream(arqDes);
            prof1 = (Professor) oDes.readObject();
            oDes.close();
            arqDes.close();

            System.out.println("---------------------------------------------");

            /* Recuperando valores do objeto */
            System.out.println(prof1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
