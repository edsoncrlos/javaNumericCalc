package br.ufma.edson.javacalc.curveFitting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeastSquaresTest {
    private CurveFitting leastSquare;
    private final double delta = 1e-9;

    @Test
    void shouldBeFunctionCorrect() {
        double[] x = {8.0, 9.0, 10.0, 11.0, 12.0};
        double[] y = {2.1, 2.8, 3.1, 4.0, 4.8};

        leastSquare = new LeastSquares(x, y);

        double a = leastSquare.getValueA();
        double b = leastSquare.getValueB();

        assertEquals(33.0/50.0, a, delta);
        assertEquals(-81.0/25.0, b, delta);
    }

    @Test
    void shouldBeEvaluateFunctionCorrect() {
        double[] x = {8.0, 9.0, 10.0, 11.0, 12.0};
        double[] y = {2.1, 2.8, 3.1, 4.0, 4.8};

        leastSquare = new LeastSquares(x, y);

        double result = leastSquare.evaluate(13.0);
        assertEquals(267.0/50.0, result, delta);
    }
}
