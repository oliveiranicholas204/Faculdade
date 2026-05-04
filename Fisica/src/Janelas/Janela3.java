package Janelas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.DecimalFormat;

//CRIAÇÃO CLASSE JANELA3
class Janela3 extends JFrame {

    private JPanel painel;

    //COMPONENTES COMO ATRIBUTOS PARA PODER REDIMENSIONAR
    private JLabel titulo, l1, l2, l3, l4, l5;
    private JButton btnRetornar;

    //TAMANHO BASE 
    private final int BASE_W = 650;
    private final int BASE_H = 450;

    //MENSAGEM DE ERRO CASO ACONTEÇA
    private void mostrarErro(String msg) {
        JOptionPane.showMessageDialog(
            this,
            msg,
            "Valor inválido",
            JOptionPane.WARNING_MESSAGE
        );
    }

    //CRIAÇÃO DA JANELA, DESIGN E PASSAGEM DE PARAMETROS DOS RESULTADOS
    public Janela3(double atritoMin, double atritoMax, double Vcolisao, double VcolisaoKm, double Fcurva, String Decisao) {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, BASE_W, BASE_H);

        //MOSTRA OS RESULTADOS EM DECIMAL
        DecimalFormat df = new DecimalFormat("0.0");

        painel = new JPanel();
        painel.setLayout(null);
        painel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(painel);

        //TITULO
        titulo = new JLabel("Resultados");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        //BOTÃO RETORNAR
        btnRetornar = new JButton("Retornar");

        //CAIXAS DE TEXTO COM OS RESULTADOS
        l1 = new JLabel("Atrito mínimo para frear: " + df.format(atritoMin) + " N");
        l2 = new JLabel("Atrito máximo possível: " + df.format(atritoMax) + " N");

        if (Vcolisao < 0) {
            l3 = new JLabel("Velocidade do impacto: 0m/s ou 0 km/h");
        } else {
            l3 = new JLabel("Velocidade do impacto: " + df.format(Vcolisao) +
                    " m/s ou " + df.format(VcolisaoKm) + " km/h");
        }

        l4 = new JLabel("Força necessária para desviar: " + df.format(Fcurva) + " N");

        l5 = new JLabel(Decisao);
        l5.setHorizontalAlignment(SwingConstants.CENTER);

        //ADICIONA COMPONENTES
        painel.add(titulo);
        painel.add(l1);
        painel.add(l2);
        painel.add(l3);
        painel.add(l4);
        painel.add(l5);
        painel.add(btnRetornar);

        //FECHA A JANELA ATUAL
        btnRetornar.addActionListener(e -> dispose());

        //APLICA POSIÇÃO INICIAL
        aplicarLayout(BASE_W, BASE_H);

        //REDIMENSIONAMENTO DINÂMICO
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                Dimension size = getSize();
                aplicarLayout(size.width, size.height);
            }
        });
    }

    //MÉTODO QUE REPOSICIONA TUDO DE FORMA PROPORCIONAL
    private void aplicarLayout(int w, int h) {

        double sx = (double) w / BASE_W;
        double sy = (double) h / BASE_H;

        //TITULO (NEGRITO)
        titulo.setBounds((int)(50*sx), (int)(5*sy), (int)(550*sx), (int)(30*sy));
        titulo.setFont(new Font("Arial", Font.BOLD, (int)(20 * sy)));

        //LABELS (NEGRITO)
        l1.setBounds((int)(350*sx), (int)(90*sy), (int)(300*sx), (int)(25*sy));
        l1.setFont(new Font("Arial", Font.BOLD, (int)(12 * sy)));

        l2.setBounds((int)(50*sx), (int)(90*sy), (int)(300*sx), (int)(25*sy));
        l2.setFont(new Font("Arial", Font.BOLD, (int)(12 * sy)));

        l3.setBounds((int)(50*sx), (int)(190*sy), (int)(350*sx), (int)(25*sy));
        l3.setFont(new Font("Arial", Font.BOLD, (int)(12 * sy)));

        l4.setBounds((int)(350*sx), (int)(190*sy), (int)(300*sx), (int)(25*sy));
        l4.setFont(new Font("Arial", Font.BOLD, (int)(12 * sy)));

        l5.setBounds((int)(100*sx), (int)(300*sy), (int)(450*sx), (int)(30*sy));
        l5.setFont(new Font("Arial", Font.BOLD, (int)(14 * sy)));

        //BOTÃO
        btnRetornar.setBounds((int)(500*sx), (int)(350*sy), (int)(120*sx), (int)(30*sy));
    }
}