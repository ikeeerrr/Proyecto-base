package es.pau.calculadora.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalculadoraView extends JFrame {
    public JPanel p;
    public JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    public JButton equalsButton, sumButton, c, dotButton, circButton, bFact, bExp;
    public JLabel text;

    public CalculadoraView() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 600);

        p = new JPanel();
        p.setLayout(null);
        setContentPane(p);

        text = new JLabel("0");
        text.setHorizontalAlignment(4);
        text.setBounds(50, 20, 300, 50);
        p.add(text);

        // Inicialización de todos los botones
        b7 = new JButton("7"); b7.setBounds(50, 100, 60, 60); p.add(b7);
        b8 = new JButton("8"); b8.setBounds(120, 100, 60, 60); p.add(b8);
        b9 = new JButton("9"); b9.setBounds(190, 100, 60, 60); p.add(b9);
        
        b4 = new JButton("4"); b4.setBounds(50, 170, 60, 60); p.add(b4);
        b5 = new JButton("5"); b5.setBounds(120, 170, 60, 60); p.add(b5);
        b6 = new JButton("6"); b6.setBounds(190, 170, 60, 60); p.add(b6);
        
        b1 = new JButton("1"); b1.setBounds(50, 240, 60, 60); p.add(b1);
        b2 = new JButton("2"); b2.setBounds(120, 240, 60, 60); p.add(b2);
        b3 = new JButton("3"); b3.setBounds(190, 240, 60, 60); p.add(b3);
        
        b0 = new JButton("0"); b0.setBounds(50, 310, 60, 60); p.add(b0);
        
        sumButton = new JButton("+"); sumButton.setBounds(120, 310, 60, 60); p.add(sumButton);
        equalsButton = new JButton("="); equalsButton.setBounds(190, 310, 60, 60); p.add(equalsButton);
        c = new JButton("C"); c.setBounds(260, 310, 60, 60); p.add(c);
        
        dotButton = new JButton("."); dotButton.setBounds(50, 380, 60, 60); p.add(dotButton);
        circButton = new JButton("Circum"); circButton.setBounds(120, 380, 60, 60); p.add(circButton);
        bFact = new JButton("!"); bFact.setBounds(190, 380, 60, 60); p.add(bFact);
        bExp = new JButton("Exp"); bExp.setBounds(260, 380, 60, 60); p.add(bExp);
    }

    public void actualizarPantalla(String valor) {
        text.setText(valor);
    }
}