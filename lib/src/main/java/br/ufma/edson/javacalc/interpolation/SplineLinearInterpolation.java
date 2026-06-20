package br.ufma.edson.javacalc.interpolation;

public class SplineLinearInterpolation implements Interpolation {

    @Override
    public double interpolate(double[] x, double[] y, double point) {
        int n = x.length;

        for (int i = 0; i < n - 1; i++) {
            // Search interval
            if (point >= x[i] && point <= x[i + 1]) {

                double term = (y[i + 1] - y[i]) / (x[i + 1] - x[i]);

                return y[i] + term * (point - x[i]);
            }
        }

        return Double.NaN;
    }
}
