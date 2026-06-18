package br.ufma.edson.javacalc.interpolation;

public class GregoryNewtonInterpolation implements Interpolation{
    private static final double EPSILON = 1e-10;

    @Override
    public double interpolate(double[] x, double[] y, double point) {

        double step = getUniformStep(x);
        double[][] differences = buildDifferenceTable(y);

        double normalizedPoint = (point - x[0]) / step;

        return evaluatePolynomial(differences, normalizedPoint);
    }

    private double getUniformStep(double[] x) {
        double step = x[1] - x[0];

        for (int i = 2; i < x.length; i++) {
            double currentStep = x[i] - x[i - 1];

            if (Math.abs(currentStep - step) > EPSILON) {
                throw new IllegalArgumentException(
                        "Gregory-Newton interpolation requires equally spaced x values.");
            }
        }

        return step;
    }

    private double[][] buildDifferenceTable(double[] y) {
        int n = y.length;
        double[][] differences = new double[n][n];

        for (int i = 0; i < n; i++) {
            differences[i][0] = y[i];
        }

        for (int order = 1; order < n; order++) {
            for (int row = 0; row < n - order; row++) {
                differences[row][order] =
                        differences[row + 1][order - 1]
                                - differences[row][order - 1];
            }
        }

        return differences;
    }

    private double evaluatePolynomial(
            double[][] differences,
            double normalizedPoint
    ) {
        int n = differences.length;

        double result = differences[0][0];
        double numerator = 1.0;
        double denominator = 1.0;

        for (int order = 1; order < n; order++) {
            numerator *= (normalizedPoint - (order - 1));
            denominator *= order;

            result += (numerator / denominator)
                    * differences[0][order];
        }

        return result;
    }
}
