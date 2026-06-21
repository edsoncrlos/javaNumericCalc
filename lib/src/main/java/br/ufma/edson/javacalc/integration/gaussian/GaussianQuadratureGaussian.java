package br.ufma.edson.javacalc.integration.gaussian;

public class GaussianQuadratureGaussian implements Gaussian {
    @Override
    public double gaussianQuadrature(Function function, double a, double b, int n) {
        double[] abscissas;
        double[] weights;

        a = -1.0;
        b = 1.0;

        switch (n) {
            case 2:
                abscissas = new double[]{-1.0 / Math.sqrt(3), 1.0 / Math.sqrt(3)};
                weights = new double[]{1.0, 1.0};
                break;

            case 3:
                abscissas = new double[]{-Math.sqrt(3.0 / 5.0), 0.0, Math.sqrt(3.0 / 5.0)};
                weights = new double[]{5.0 / 9.0, 8.0 / 9.0, 5.0 / 9.0};
                break;

            default:
                throw new IllegalArgumentException("n should be 2 or 3");

        }
        double sum = 0.0;

        for (int i = 0; i < n; i++) {
            double x = ((b - a) / 2.0) * abscissas[i] + (a + b) / 2.0;

            sum += weights[i] * function.evaluate(x);
        }

        return (b - a) / 2.0 * sum;
    }
}
