package br.ufma.edson.javacalc.interpolation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SplineCubicInterpolationTest {
    private Interpolation splineCubicInterpolation;
    private final double delta = 1e-9;

    @BeforeEach
    public void setup() {
        splineCubicInterpolation = new SplineCubicInterpolation();
    }

    @Test
    void shouldReturnExactValueForKnownPoint() {
        double[] x = {1.0, 2.0, 3.0};
        double[] y = {1.0, 4.0, 9.0};

        double result = splineCubicInterpolation.interpolate(x, y, 2.0);

        assertEquals(4.0, result, delta);
    }

    @Test
    void shouldInterpolateLinearFunction() {
        double[] x = {0.0, 2.0};
        double[] y = {1.0, 5.0};

        double result = splineCubicInterpolation.interpolate(x, y, 1.0);

        assertEquals(3.0, result, delta);
    }

    @Test
    void shouldInterpolateQuadraticFunction() {
        double[] x = {0.0, 1.0, 2.0, 3.0, 4.0};
        double[] y = {0.0, 1.0, 4.0, 9.0, 16.0};

        double result = splineCubicInterpolation.interpolate(x, y, 2.5);

        assertEquals(349.0/56.0, result, delta);
    }

    @Test
    void shouldInterpolateInsideSecondSegment() {
        double[] x = {0.0, 1.0, 3.0};
        double[] y = {0.0, 2.0, 6.0};

        double result = splineCubicInterpolation.interpolate(x, y, 2.0);

        assertEquals(4.0, result, delta);
    }

    @Test
    void shouldBeCorrect() {
        double[] x = {0.0, 1.0, 2.0, 3.0};
        double[] y = {2.5, 4.5, 3.0, 6.0};

        double result = splineCubicInterpolation.interpolate(x, y, 1.5);

        assertEquals(147.0/40.0, result, delta);
    }
}
