package br.ufma.edson.javacalc.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrapezeNewtonCotesTest {
    private NewtonCotes trapeze;
    private final double delta = 1e-9;

    @BeforeEach
    public void setup() {
        trapeze = new TrapezeNewtonCotes();
    }

    @Test
    void shouldBeFunctionCorrect() {
        double[] x = {0.0, 0.5, 1.0, 1.5, 2.0};
        double[] y = {0.0, 40.0, 65.0, 80.0, 90.0};

        double result = trapeze.integrate(x, y);

        assertEquals(115, result, delta);
    }
}
