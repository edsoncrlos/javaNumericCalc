package br.ufma.edson.javacalc.integration;

public class TrapezeNewtonCotes implements NewtonCotes {
    @Override
    public double integrate(double[] x, double[] y) {
        double h = x[1] - x[0];

        double sum = (y[0] + y[y.length - 1]) / 2.0;

        for (int i = 1; i < y.length - 1; i++) {
            sum += y[i];
        }

        return h * sum;
    }
}
