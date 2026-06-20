package br.ufma.edson.javacalc.integration;

public class Simpson38NewtonCotes implements NewtonCotes {
    @Override
    public double integrate(double[] x, double[] y) {
        double h = x[1] - x[0];

        return (3.0 * h / 8.0) *
                (y[0] + 3 * y[1] + 3 * y[2] + y[3]);
    }
}
