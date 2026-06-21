package br.ufma.edson.javacalc.integration.gaussian;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GaussianQuadratureGaussianTest {
    private Gaussian gaussianQuadrature;
    private final double delta = 1e-9;

    @BeforeEach
    public void setup() {
        gaussianQuadrature = new GaussianQuadratureGaussian();
    }

    @Test
    void shouldBeFunctionCorrect() {
        double[] x = {0.0, 0.5, 1.0, 1.5, 2.0};
        double[] y = {0.0, 40.0, 65.0, 80.0, 90.0};

        double result = gaussianQuadrature.gaussianQuadrature(
                new TorqueFunction(),
                -1.0,
                1.0,
                2
        );

        assertEquals(26.0/3.0, result, delta);
    }
}
