package br.ufma.edson.javacalc.interpolation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewtonInterpolationTest {
    private Interpolation newtonInterpolation;
    private final double delta = 1e-9;

    @BeforeEach
    public void setup() {
        newtonInterpolation = new NewtonInterpolation();
    }

    @Test
    void shouldReturnExactValueForKnownPoint() {
        double[] x = {1.0, 2.0, 3.0};
        double[] y = {1.0, 4.0, 9.0};

        double result = newtonInterpolation.interpolate(x, y, 2.0);

        assertEquals(4.0, result, delta);
    }

    @Test
    void shouldInterpolateLinearFunction() {
        double[] x = {0.0, 2.0};
        double[] y = {1.0, 5.0};

        double result = newtonInterpolation.interpolate(x, y, 1.0);

        assertEquals(3.0, result, delta);
    }

    @Test
    void shouldInterpolateQuadraticFunction() {
        double[] x = {1.0, 2.0, 3.0};
        double[] y = {1.0, 4.0, 9.0};

        double result = newtonInterpolation.interpolate(x, y, 2.5);

        assertEquals(6.25, result, delta);
    }

    @Test
    void shouldInterpolateCubicFunction() {
        double[] x = {1.0, 2.0, 3.0, 4.0};
        double[] y = {1.0, 8.0, 27.0, 64.0};

        double result = newtonInterpolation.interpolate(x, y, 2.5);

        assertEquals(15.625, result, delta);
    }

    @Test
    void shouldInterpolateAtBoundaryPoint() {
        double[] x = {0.0, 1.0, 2.0};
        double[] y = {0.0, 1.0, 4.0};

        double result = newtonInterpolation.interpolate(x, y, 0.0);

        assertEquals(0.0, result, delta);
    }

    @Test
    void shouldBeCorrect() {
        double[] x = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] y = {1.2, 1.9, 3.2, 5.5, 8.2};

        double result = newtonInterpolation.interpolate(x, y, 3.5);

        assertEquals(2713.0/640.0, result, delta);
    }
}
