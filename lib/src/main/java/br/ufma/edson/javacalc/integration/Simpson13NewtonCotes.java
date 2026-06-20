package br.ufma.edson.javacalc.integration;

public class Simpson13NewtonCotes implements NewtonCotes {
    @Override
    public double integrate(double[] x, double[] y) {
        double h = x[1] - x[0];

        double soma = y[0] + y[y.length - 1];

        for (int i = 1; i < y.length - 1; i++) {
            if (i % 2 == 1) {
                soma += 4 * y[i];
            } else {
                soma += 2 * y[i];
            }
        }

        return (h / 3.0) * soma;
    }
}
