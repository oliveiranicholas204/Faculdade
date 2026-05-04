package Janelas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

//CRIA A CLASSE JANELA2
class Janela2 extends JFrame {

    private JPanel painel;

    //TAMANHO BASE
    private final int BASE_W = 620;
    private final int BASE_H = 400;

    //MENSAGEM DE ERRO CASO ALGO ACONTEÇA
    private void mostrarErro(String msg) {
        JOptionPane.showMessageDialog(
            this,
            msg,
            "Valor inválido",
            JOptionPane.WARNING_MESSAGE
        );
    }

    //FUNÇÃO PARA ESCALAR COMPONENTES
    private void aplicarEscala(Component c, double s, int x, int y, int w, int h) {
        c.setBounds(
            (int)(x * s),
            (int)(y * s),
            (int)(w * s),
            (int)(h * s)
        );
    }

    //SEGUNDA JANELA
    public Janela2() {

        //DESIGN DA JANELA
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, BASE_W, BASE_H);

        painel = new JPanel();
        painel.setLayout(null);
        painel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(painel);

        //TIULO
        JLabel titulo = new JLabel("Preencha os dados");
        painel.add(titulo);

        //LABELS
        JLabel l1 = new JLabel("Distância(m)");
        JLabel l2 = new JLabel("Massa(kg)");
        JLabel l3 = new JLabel("Velocidade Inicial(m/s)");
        JLabel l4 = new JLabel("Coeficiente de Atrito Estático");
        JLabel l5 = new JLabel("Coeficiente de Atrito Cinético");
        JLabel l6 = new JLabel("Largura do Desvio(m)");

        painel.add(l1);
        painel.add(l2);
        painel.add(l3);
        painel.add(l4);
        painel.add(l5);
        painel.add(l6);

        //CAIXAS DE TEXTO
        JTextField c1 = new JTextField();
        JTextField c2 = new JTextField();
        JTextField c3 = new JTextField();
        JTextField c4 = new JTextField();
        JTextField c5 = new JTextField();
        JTextField c6 = new JTextField();

        painel.add(c1);
        painel.add(c2);
        painel.add(c3);
        painel.add(c4);
        painel.add(c5);
        painel.add(c6);

        //BOTÕES
        JButton calcular = new JButton("Calcular");
        JButton resetar = new JButton("Resetar");

        painel.add(calcular);
        painel.add(resetar);

        //POSIÇÕES BASE 
        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {

                double scaleX = getWidth() / (double) BASE_W;
                double scaleY = getHeight() / (double) BASE_H;
                double scale = Math.min(scaleX, scaleY);

                //TÍTULO
                aplicarEscala(titulo, scale, 10, 10, 580, 25);
                titulo.setFont(new Font("Arial", Font.BOLD, (int)(16 * scale)));

                //LABELS
                aplicarEscala(l1, scale, 40, 50, 150, 20);
                aplicarEscala(l2, scale, 230, 50, 150, 20);
                aplicarEscala(l3, scale, 420, 50, 220, 20);
                aplicarEscala(l4, scale, 40, 120, 220, 20);
                aplicarEscala(l5, scale, 230, 120, 220, 20);
                aplicarEscala(l6, scale, 420, 120, 220, 20);

                //FIELDS
                aplicarEscala(c1, scale, 40, 80, 120, 25);
                aplicarEscala(c2, scale, 230, 80, 120, 25);
                aplicarEscala(c3, scale, 420, 80, 120, 25);
                aplicarEscala(c4, scale, 40, 145, 120, 25);
                aplicarEscala(c5, scale, 230, 145, 120, 25);
                aplicarEscala(c6, scale, 420, 145, 120, 25);

                //BOTÕES
                aplicarEscala(resetar, scale, 30, 300, 120, 30);
                aplicarEscala(calcular, scale, 450, 300, 120, 30);
            }
        });

        //RESETA OS VALORES
        resetar.addActionListener(e -> {
            c1.setText("");
            c2.setText("");
            c3.setText("");
            c4.setText("");
            c5.setText("");
            c6.setText("");
        });

        calcular.addActionListener(e -> {

            try {
            	//CRIAÇÃO DAS VARIÁVEIS
                double distancia = Double.parseDouble(c1.getText().trim());
                double massa = Double.parseDouble(c2.getText().trim());
                double velocidade = Double.parseDouble(c3.getText().trim());
                double atritoEst = Double.parseDouble(c4.getText().trim());
                double atritoCin = Double.parseDouble(c5.getText().trim());
                double larguraDesvio = Double.parseDouble(c6.getText().trim());

                //DECISÃO DOS LIMITES
                if (distancia < 5 || distancia > 500) {
                	mostrarErro("Distância deve ser entre 5 a 500");
                	return;
                	}
                if (massa < 800 || massa > 2500) {
                	mostrarErro("Massa deve ser 800 a 2500");
                	return;
                	}
                if (velocidade < 5 || velocidade > 40) {
                	mostrarErro("Velocidade deve ser entre 5 a 40");
                	return;
                	}
                if (atritoEst < 0.1 || atritoEst > 1) {
                	mostrarErro("Atrito estático deve ser entre 0.1 e 1");
                	return; 
                	}
                if (atritoCin < 0.05 || atritoCin > atritoEst) {
                	mostrarErro("Atrito cinético inválido");
                	return;
                	}
                if (larguraDesvio < 0.1 || larguraDesvio > 3.0) {
                	mostrarErro("Largura inválida");
                	return;
                	}
                //CÁLCULOS
                double atritoMax = atritoEst * massa * 9.81;
                double atritoMin = (massa * Math.pow(velocidade, 2)) / (2 * distancia);
                double raioDesvio = (Math.pow(distancia, 2) + Math.pow(larguraDesvio, 2)) / (2 * larguraDesvio);
                double Fcurva = (massa * Math.pow(velocidade, 2)) / raioDesvio;
                double aceleracao = atritoCin * 9.81;
                double VcolisaoSq = Math.pow(velocidade, 2) - (2 * aceleracao * distancia);
                double Vcolisao;
                if (VcolisaoSq <= 0) {
                	Vcolisao = 0;
                	}
                else {
                	Vcolisao = Math.sqrt(VcolisaoSq);
                	}
                double VcolisaoKm = Vcolisao * 3.6;

                //DECIDIR MELHOR ESCOLHA
                String Decisao;

                if (atritoMin <= atritoMax && atritoMin <= Fcurva) {
                    Decisao = "Resultado: A melhor opção é frear.";
                } else if (atritoMin > atritoMax && Fcurva <= atritoMax) {
                    Decisao = "Resultado: A melhor opção é desviar.";
                } else if (atritoMin <= atritoMax && Fcurva <= atritoMax) {
                    Decisao = "Resultado: Ambos são possíveis, mas frear é geralmente mais seguro.";
                } else {
                    Decisao = "Resultado: Colisão inevitável.";
                }

                //DIZER QUE OS CÁLCULOS FORAM FEITOS
                JOptionPane.showMessageDialog(this, "Cálculo realizado com sucesso!");

                //CRIAR JANELA3
                Janela3 frame3 = new Janela3(atritoMin, atritoMax, Vcolisao, VcolisaoKm, Fcurva, Decisao);
                frame3.setVisible(true);
                //MENSAGEM AVISANDO QUE ALGO NÃO FOI PREENCHIDO OU FOI PREENCHIDO ERRADO
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Preencha corretamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}