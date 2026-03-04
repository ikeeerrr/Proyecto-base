package es.pau.calculadora.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import es.pau.calculadora.model.CalculadoraModel;
import es.pau.calculadora.view.CalculadoraView;

public class Main implements ActionListener {
    private CalculadoraView view;
    private CalculadoraModel model;

    public double current = 0, memory;
    public int dotDigits = 0;
    public String a = "n"; // s (suma), e (exponente), n (nada)

    public Main() {
        this.view = new CalculadoraView();
        this.model = new CalculadoraModel();
        
        // Conectar eventos
        registrarEventos();
        
        this.view.setVisible(true);
    }

    private void registrarEventos() {
        view.b0.addActionListener(this); view.b1.addActionListener(this);
        view.b2.addActionListener(this); view.b3.addActionListener(this);
        view.b4.addActionListener(this); view.b5.addActionListener(this);
        view.b6.addActionListener(this); view.b7.addActionListener(this);
        view.b8.addActionListener(this); view.b9.addActionListener(this);
        view.sumButton.addActionListener(this);
        view.equalsButton.addActionListener(this);
        view.c.addActionListener(this);
        view.dotButton.addActionListener(this);
        view.circButton.addActionListener(this);
        view.bFact.addActionListener(this);
        view.bExp.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        Object src = ev.getSource();

        // Lógica de números
        handleNumbers(src);

        // Lógica de operaciones
        if (src == view.sumButton || src == view.bExp) {
            if (a.equals("s")) memory = model.sumar(current, memory);
            else if (a.equals("e")) memory = model.calculatee(memory, current);
            else memory = current;

            current = 0;
            dotDigits = 0;
            a = (src == view.sumButton) ? "s" : "e";
            view.actualizarPantalla("0");
        }

        if (src == view.equalsButton) {
            if (a.equals("s")) current = model.sumar(memory, current);
            else if (a.equals("e")) current = model.calculatee(memory, current);
            
            view.actualizarPantalla(String.valueOf(current));
            a = "n";
            dotDigits = 0;
        }

        if (src == view.c) {
            current = 0; memory = 0; dotDigits = 0; a = "n";
            view.actualizarPantalla("0");
        }

        if (src == view.circButton) {
            current = model.calcularCircunferencia(current);
            view.actualizarPantalla(String.valueOf(current));
        }

        if (src == view.bFact) {
            current = model.calculatef(current);
            view.actualizarPantalla(String.valueOf(current));
        }
        
        if (src == view.dotButton && dotDigits == 0) {
            dotDigits = 1;
            view.actualizarPantalla(String.format("%.0f.", current));
        }
    }

    private void handleNumbers(Object src) {
        int digit = -1;
        if (src == view.b0) digit = 0;
        else if (src == view.b1) digit = 1;
        else if (src == view.b2) digit = 2;
        else if (src == view.b3) digit = 3;
        else if (src == view.b4) digit = 4;
        else if (src == view.b5) digit = 5;
        else if (src == view.b6) digit = 6;
        else if (src == view.b7) digit = 7;
        else if (src == view.b8) digit = 8;
        else if (src == view.b9) digit = 9;

        if (digit != -1) {
            if (dotDigits == 0) {
                current = current * 10 + digit;
            } else {
                current = current + digit * Math.pow(10, -dotDigits);
                dotDigits++;
            }
            view.actualizarPantalla(String.valueOf(current));
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}