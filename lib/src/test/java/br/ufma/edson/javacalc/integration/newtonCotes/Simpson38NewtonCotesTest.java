package br.ufma.edson.javacalc.integration.newtonCotes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Simpson38NewtonCotesTest {
    private NewtonCotes newtonCotesSimpson38;
    private final double delta = 1e-9;

    @BeforeEach
    public void setup() {
        newtonCotesSimpson38 = new Simpson38NewtonCotes();
    }

    @Test
    void shouldBeFunctionCorrect() {
        double[] x = {0.0, 2.0, 4.0, 6.0};
        double[] y = {10.0, 15.0, 12.0, 8.0};

        double result = newtonCotesSimpson38.integrate(x, y);

        assertEquals(74.25, result, delta);
    }
}
