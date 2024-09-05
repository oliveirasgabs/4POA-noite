package agenda;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Agenda {
    public static void escrita(String nome, String telefone){

        try{
            FileWriter fw = new FileWriter("c:/Users/gabiz/Documents/Faculdade/4POA-noite/desafio-agenda/src/agenda/agenda.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(nome+";"+telefone);
            bw.newLine();
            bw.close();
            fw.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void lerTodos(){
        try{
            FileReader fr = new FileReader("c:/Users/gabiz/Documents/Faculdade/4POA-noite/desafio-agenda/src/agenda/agenda.txt");
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()){
                String aux = br.readLine();
                String [] dados = aux.split(";");
                System.out.println("Nome:" + dados[0] + "- Telefone:" + dados[1]);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void ler (String nome){
        try{
            FileReader fr = new FileReader("c:/Users/gabiz/Documents/Faculdade/4POA-noite/desafio-agenda/src/agenda/agenda.txt");
            BufferedReader br = new BufferedReader(fr);
            boolean encontrado = false;
            while(br.ready()){
                String aux = br.readLine();
                if(aux.contains(nome)){
                    String [] dados = aux.split(";");
                    System.out.println("Nome:" + dados[0] + "- Telefone:" + dados[1]);
                    encontrado = true;
                }
            }
            if(!encontrado){
                System.out.println("Dados não encontrados!");
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    
    }
}
