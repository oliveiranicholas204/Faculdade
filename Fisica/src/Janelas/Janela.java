package Janelas;

import javax.swing.*;
import java.awt.*;

//CRIA A CLASSE JANELA
public class Janela extends JFrame {

    //TAMANHO BASE PARA ESCALA
    private final int BASE_W = 620;
    private final int BASE_H = 300;

    //COMPONENTES PRINCIPAIS (PARA REDIMENSIONAR)
    private JLabel titulo;
    private JLabel contexto;
    private JButton botao;

    private JPanel contentPane;
    private JPanel painelTitulo;
    private JPanel painelCentro;
    private JPanel painelBotao;

    //PRIMEIRA JANELA
    public Janela() {
        //DESIGN
        setTitle("Calculador de Frenagem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(BASE_W, BASE_H);
        setLocationRelativeTo(null);

        contentPane = new JPanel(new BorderLayout(10, 10));
        setContentPane(contentPane);

        //TITULO
        titulo = new JLabel("Bem-vindo ao Calculador de Frenagem e Atrito");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        painelTitulo = new JPanel(new BorderLayout());
        painelTitulo.add(titulo, BorderLayout.CENTER);

        //PAINEL CENTRAL
        painelCentro = new JPanel(new GridBagLayout());

        JPanel textos = new JPanel();
        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));

        //EXPLICAÇÃO DO PROBLEMA
        contexto = new JLabel(
            "<html><div style='text-align:center; width:450px;'>" +
            "Contexto:<br><br>" +
            "Um motorista distraído percebe que está perto de bater em um muro e não sabe se é melhor tentar frear ou desviar. " +
            "O programa calcula e decide qual a melhor opção através de certos valores oferecidos." +
            "</div></html>"
        );

        contexto.setHorizontalAlignment(SwingConstants.CENTER);
        contexto.setFont(new Font("Arial", Font.BOLD, 12));

        textos.add(contexto);
        painelCentro.add(textos);

        //BOTÃO COMEÇAR
        botao = new JButton("Começar");
        botao.setFont(new Font("Arial", Font.BOLD, 14));

        botao.addActionListener(e -> {
            new Janela2().setVisible(true);
            dispose();
        });

        painelBotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelBotao.add(botao);

        //MOSTRA OS COMPONENTES NA JANELA
        contentPane.add(painelTitulo, BorderLayout.NORTH);
        contentPane.add(painelCentro, BorderLayout.CENTER);
        contentPane.add(painelBotao, BorderLayout.SOUTH);

        //REDIMENSIONAMENTO DINÂMICO
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                Dimension size = getSize();
                aplicarLayout(size.width, size.height);
            }
        });

        aplicarLayout(BASE_W, BASE_H);
    }

    //APLICA ESCALA PROPORCIONAL
    private void aplicarLayout(int w, int h) {

        double sy = (double) h / BASE_H;

        //TITULO
        titulo.setFont(new Font("Arial", Font.BOLD, (int)(18 * sy)));

        //TEXTO
        contexto.setFont(new Font("Arial", Font.BOLD, (int)(12 * sy)));

        //BOTÃO
        botao.setFont(new Font("Arial", Font.BOLD, (int)(14 * sy)));
    }
}