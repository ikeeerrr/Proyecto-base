package es.pau.calculadora.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    
    // Instanciamos tu modelo
    CalculadoraTest model = new CalculadoraTest();

    @Test
    public void testSuma() {
        // Verifica que 5 + 5 sean 10.0
        assertEquals(10.0, model.sumar(5.0, 5.0), "La suma no funciona correctamente");
    }

    @Test
    public void testFactorial() {
        // Verifica que el factorial de 5 sea 120
        // Asegúrate de que tu método en el modelo se llame 'calculatef'
        assertEquals(120, model.calculatef(5), "El cálculo del factorial ha fallado");
    }

    @Test
    public void testExponente() {
        // Verifica que 2 elevado a 3 sea 8.0
        // Asegúrate de que tu método se llame 'calculatee'
        assertEquals(8.0, model.calculatee(2, 3), "El cálculo del exponente ha fallado");
    }
}