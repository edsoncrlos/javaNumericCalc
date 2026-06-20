package br.ufma.edson.javacalc.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Simpson13NewtonCotesTest {
    private NewtonCotes simpson13;
    private final double delta = 1e-9;

    @BeforeEach
    public void setup() {
        simpson13 = new Simpson13NewtonCotes();
    }

    @Test
    void shouldBeFunctionCorrect() {
        double[] x = {0.0, 0.5, 1.0, 1.5, 2.0};
        double[] y = {0.0, 40.0, 65.0, 80.0, 90.0};

        double result = simpson13.integrate(x, y);

        assertEquals(350.0/3.0, result, delta);
    }
}
