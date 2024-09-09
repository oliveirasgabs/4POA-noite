package control;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PessoaThread extends JLabel implements Runnable {
    private Thread pessoaThread = null;
    private int posX;
    private int posY;
    private ImageIcon imagem;
    private static int pos = 0;
    private String nome;

    // CONSTRUTOR DEFAULT
    public PessoaThread() {
    }

    // CONSTRUTOR SOBRECARREGADO
    public PessoaThread(String nome, ImageIcon img, int posX, int posY) {
        super(img);
        this.imagem = img;
        this.posX = posX;
        this.posY = posY;
        this.nome = nome;

        pessoaThread = new Thread(this, nome);
        pessoaThread.start();
    }

    // METODO RUN() DA INTERFACE RUNNABLE
    @Override
    public void run() {
        posX += new Random().nextInt(3) * 50;
        this.setLocation(posX, posY);

        if (posX >= 1280) {
            pos++;
            JOptionPane.showMessageDialog(null, pos + ")" + nome);
            return;
        }

        try {
            Thread.sleep(new Random().nextInt(5) * 100);
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
