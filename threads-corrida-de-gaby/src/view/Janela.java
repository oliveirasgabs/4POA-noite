package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import control.PessoaThread;

@SuppressWarnings("serial")
public class Janela extends JFrame implements ActionListener {

    private JButton btnCorrida;
    private JButton btnCancel;
    private JLabel lblPista;
    private JLabel lblVelocimetro;
    private ImageIcon imgPessoa1;
    private ImageIcon imgPessoa2;
    private ImageIcon imgPessoa3;
    private ImageIcon pista;
    private ImageIcon velocimetro;

    public Janela() {
        super();
        // ADICIONANDO ELEMENTOS AO FORMULARIO
        this.setLayout(null);
        this.setSize(1280, 900);
        this.setLocation(50, 50);
        this.setResizable(false);
        getContentPane().setBackground(Color.white);

        this.setTitle("Corrida de Gabys!");
        
        this.lblPista = new JLabel(pista);
        this.lblVelocimetro = new JLabel(velocimetro);
        // POSICIONANDO OS ELEMENTOS DO FORM
        this.lblVelocimetro.setBounds(200, 490, 150, 150);
        this.lblPista.setBounds(0, 0, 1280, 900);

        this.add(lblPista);
        this.lblPista.add(lblVelocimetro);

        this.lblPista.setBackground(Color.BLACK);

        this.btnCorrida = new JButton("Começar!");
        this.btnCancel = new JButton("Parar corrida!");
        // POSIONANDO OS BOTÕES
        this.btnCorrida.setBounds(500, 750, 120, 50);
        this.btnCancel.setBounds(640, 750, 120, 50);
        // INSERINDO AS IMAGENS DAS GABYS
        imgPessoa1 = new ImageIcon("./src/imagens/rosa.png");
        imgPessoa2 = new ImageIcon("./src/imagens/roxo.png");
        imgPessoa3 = new ImageIcon("./src/imagens/verde.png");

        this.lblPista.add(btnCorrida);
        this.lblPista.add(btnCancel);

        this.setVisible(true);

        btnCorrida.addActionListener(this);
        btnCancel.addActionListener(this);

        JPanel jPanel = new JPanel();
        jPanel.setSize(300, 70);
        jPanel.setLayout(null);
        jPanel.setLocation(970, 510);
        jPanel.setBorder(BorderFactory.createTitledBorder("[Grupo de Trabalho]"));
        jPanel.setVisible(true);

        this.repaint();
    }

    // INSERINDO AS JLABELS DAS PESSOAS
    public JLabel JLabelPessoas(String nome, ImageIcon img, int posX, int posY) {
        PessoaThread pessoa = new PessoaThread(nome, img, posX, posY);
        pessoa.setSize(256, 256);
        pessoa.setVisible(true);
        this.add(pessoa);
        return pessoa;
    }

    // PROGRAMANDO A AÇÃO DOS BOTÕES
    @Override
    public void actionPerformed(ActionEvent dispara) {
        if (dispara.getSource() == this.btnCorrida) {
            this.lblPista.add(JLabelPessoas("Gaby Rosa", imgPessoa1, 0, 50));
            this.lblPista.add(JLabelPessoas("Gaby Roxa", imgPessoa2, 0, 250));
            this.lblPista.add(JLabelPessoas("Gaby Verde", imgPessoa3, 0, 450));
        }
        if (dispara.getSource() == this.btnCancel) {
            System.exit(0);
        }
    }
}
