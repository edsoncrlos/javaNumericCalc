package br.ufma.edson.javacalc.interpolation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LagrangeInterpolationTest {
    private Interpolation lagrangeInterpolation;
    private final double delta = 1e-9;

    @BeforeEach
    public void setup() {
        lagrangeInterpolation = new LagrangeInterpolation();
    }

    @Test
    void shouldBeCorrectInterpolate() {
        double[] x = {0.1, 0.6, 0.8};
        double[] y = {1.221, 3.32, 4.953};

        double result = lagrangeInterpolation.interpolate(x, y, 0.2);

        assertEquals(1.414114285714286, result, delta);
    }

    @Test
    void shouldInterpolateLinearFunction() {
        double[] x = {0.1, 0.6};
        double[] y = {1.221, 3.32};

        double result = lagrangeInterpolation.interpolate(x, y, 0.2);

        assertEquals(1.6408, result, delta);
    }

    @Test
    void shouldInterpolateQuadraticFunction() {
        double[] x = {0, 1, 2};
        double[] y = {0, 1, 4};

        double result = lagrangeInterpolation.interpolate(x, y, 1.5);

        assertEquals(2.25, result, delta);
    }

    @Test
    void shouldReturnKnownValueFromPoint() {
        double[] x = {0, 1, 2};
        double[] y = {0, 1, 4};

        double result = lagrangeInterpolation.interpolate(x, y, 2);

        assertEquals(4.0, result, delta);
    }


    @Test
    void shouldReturnPointValueWhenThereIsOnlyOnePoint() {
        double[] x = {5};
        double[] y = {10};

        double result =
                lagrangeInterpolation.interpolate(x, y, 100);

        assertEquals(10.0, result, delta);
    }

    @Test
    void shouldBeCorrect() {
        double[] x = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] y = {1.2, 1.9, 3.2, 5.5, 8.2};

        double result = lagrangeInterpolation.interpolate(x, y, 3.5);

        assertEquals(2713.0/640.0, result, delta);
    }
}
