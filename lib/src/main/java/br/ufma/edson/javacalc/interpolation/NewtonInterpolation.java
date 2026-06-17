package br.ufma.edson.javacalc.interpolation;

public class NewtonInterpolation implements Interpolation {

    private double dividedDifferences(double[] x, double[] y, int i, int j) {
        if (i == j) {
            return y[i];
        }

        return (
                dividedDifferences(x, y, i + 1, j) - dividedDifferences(x, y, i, j - 1)
        ) / (x[j] - x[i]);
    }

    @Override
    public double interpolate(double[] x, double[] y, double point) {
        int n = x.length;

        double term = 1.0;
        double result = 0.0;
        result += dividedDifferences(x, y, 0, 0);;

        for (int i = 1; i < n; i++) {
            term *= (point - x[i-1]);
            double coef = dividedDifferences(x, y, 0, i);

            result += term*coef;
        }

        return result;
    }
}
