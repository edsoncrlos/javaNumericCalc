package br.ufma.edson.javacalc.interpolation;

public class LagrangeInterpolation implements Interpolation {

    public void isVectorsCorrect(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalStateException("Length of vectors should be equal.");
        }
    }

    @Override
    public double interpolate(double[] x, double[] y, double point) {
        isVectorsCorrect(x, y);

        int n = x.length;
        double result = 0.0;

        for (int k = 0; k < n; k++) {

            // y_k
            double term = y[k];

            // y_k * L_k
            for (int j = 0; j < n; j++) {
                if (k != j) {
                    term *= (point - x[j]) / (x[k] - x[j]);
                }
            }

            result += term;
        }

        return result;
    }
}
