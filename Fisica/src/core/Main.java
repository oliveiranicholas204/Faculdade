package core;
import java.awt.EventQueue;

import Janelas.Janela;

public class Main {
    public static void main(String[] args) {
    	//ACIONA A PRIMEIRA JANELA
        EventQueue.invokeLater(() -> new Janela().setVisible(true));
    }
}
