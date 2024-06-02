import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @BeforeEach
    void setUp() {
        System.out.println("comenzando el test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tercminando el test");

    }

    @Test
    void sumar() {
    }

    @Test
    void restar() {
        Calculadora c = new Calculadora();
        int esperado=  2;
        int obtenido = c.restar(4,2);
        assertEquals(esperado,obtenido);

    }
}