
package es.pau.calculadora.model;

public class CalculadoraModel {

    /**
     * Calcula el factorial de un número.
     */
    public int calculatef(double n) {
        if (n % 1 != 0) throw new RuntimeException("n is not natural");
        if (n < 0) throw new RuntimeException("n is negative");
        int r = 1;
        for (int i = 2; i <= n; i++) {
            r *= i;
        }
        return r;
    }

    /**
     * Calcula la potencia (base ^ exponente).
     */
    public double calculatee(double b, double e) {
        if (e % 1 != 0 || e < 0) throw new RuntimeException("e is not natural");
        if (b == 0 && e == 0) throw new RuntimeException("0^0 is undefined");

        double r = 1;
        for (int i = 0; i < e; i++) {
            r *= b;
        }
        return r;
    }

    /**
     * Calcula la circunferencia dado un radio.
     */
    public double calcularCircunferencia(double radio) {
        return 3.14159 * 2 * radio;
    }

    /**
     * Suma simple para el acumulador.
     */
    public double sumar(double a, double b) {
        return a + b;
    }
}