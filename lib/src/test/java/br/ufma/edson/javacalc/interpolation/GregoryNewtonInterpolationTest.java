package br.ufma.edson.javacalc.interpolation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GregoryNewtonInterpolationTest {
    private Interpolation gregoryNewtonInterpolation;
    private final double delta = 1e-9;

    @BeforeEach
    public void setup() {
        gregoryNewtonInterpolation = new GregoryNewtonInterpolation();
    }

    @Test
    public void shouldReturnExactValueWhenPointExistsInTable() {
        double[] x = {0, 1, 2, 3};
        double[] y = {1, 3, 5, 7};

        double result = gregoryNewtonInterpolation.interpolate(x, y, 2);

        assertEquals(5.0, result, delta);
    }

    @Test
    public void shouldInterpolateLinearFunction() {
        double[] x = {0, 1, 2, 3};
        double[] y = {1, 3, 5, 7};

        double result = gregoryNewtonInterpolation.interpolate(x, y, 1.5);

        assertEquals(4.0, result, delta);
    }

    @Test
    public void shouldInterpolateQuadraticFunction() {
        double[] x = {0, 1, 2, 3};
        double[] y = {0, 1, 4, 9};

        double result = gregoryNewtonInterpolation.interpolate(x, y, 1.5);

        assertEquals(2.25, result, delta);
    }

    @Test
    public void shouldInterpolateCubicFunction() {
        double[] x = {0, 1, 2, 3};
        double[] y = {0, 1, 8, 27};

        double result = gregoryNewtonInterpolation.interpolate(x, y, 1.5);

        assertEquals(3.375, result, delta);
    }

    @Test
    public void shouldHandleNegativeValues() {
        double[] x = {-2, -1, 0, 1, 2};
        double[] y = {4, 1, 0, 1, 4};

        double result = gregoryNewtonInterpolation.interpolate(x, y, -0.5);

        assertEquals(0.25, result, delta);
    }

    @Test
    public void shouldReturnKnownValueAtLastPoint() {
        double[] x = {0, 1, 2, 3};
        double[] y = {0, 1, 4, 9};

        double result = gregoryNewtonInterpolation.interpolate(x, y, 3);

        assertEquals(9.0, result, delta);
    }

    @Test
    public void shouldReturnKnownValueAtFirstPoint() {
        double[] x = {0, 1, 2, 3};
        double[] y = {0, 1, 4, 9};

        double result = gregoryNewtonInterpolation.interpolate(x, y, 0);

        assertEquals(0.0, result, delta);
    }

    @Test
    void shouldBeCorrect() {
        double[] x = {10, 20, 30, 40};
        double[] y = {45.0, 52.0, 60.0, 71.0};

        double result = gregoryNewtonInterpolation.interpolate(x, y, 25.0);

        assertEquals(223.0/4.0, result, delta);
    }
}
