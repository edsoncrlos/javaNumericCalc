package br.ufma.edson.javacalc.interpolation;

public class SplineCubicInterpolation implements Interpolation {

    @Override
    public double interpolate(double[] x, double[] y, double point) {
        int n = x.length;

        if (point <= x[0]) return y[0];
        if (point >= x[n - 1]) return y[n - 1];

        double[] h = computeIntervals(x);
        double[] secondDerivatives = computeSecondDerivatives(y, h);

        int interval = findInterval(x, point);

        return evaluateSpline(x, y, secondDerivatives, interval, point);
    }

    private double[] computeIntervals(double[] x) {
        double[] h = new double[x.length - 1];

        for (int i = 0; i < h.length; i++) {
            h[i] = x[i + 1] - x[i];
        }

        return h;
    }

    private double[] computeSecondDerivatives(double[] y, double[] h) {
        int n = y.length;

        double[] lower = new double[n];
        double[] diag = new double[n];
        double[] upper = new double[n];
        double[] rhs = new double[n];

        // Natural spline boundary conditions
        diag[0] = 1.0;
        diag[n - 1] = 1.0;

        for (int i = 1; i < n - 1; i++) {
            lower[i] = h[i - 1];
            diag[i] = 2.0 * (h[i - 1] + h[i]);
            upper[i] = h[i];

            rhs[i] = 6.0 * (
                    (y[i + 1] - y[i]) / h[i]
                            - (y[i] - y[i - 1]) / h[i - 1]
            );
        }

        return tridiagonalSystem(lower, diag, upper, rhs);
    }

    //Thomas algorithm
    private double[] tridiagonalSystem(double[] a, double[] b, double[] c, double[] d) {
        int n = b.length;

        for (int i = 1; i < n; i++) {
            double factor = a[i] / b[i - 1];
            b[i] -= factor * c[i - 1];
            d[i] -= factor * d[i - 1];
        }

        double[] x = new double[n];
        x[n - 1] = d[n - 1] / b[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            x[i] = (d[i] - c[i] * x[i + 1]) / b[i];
        }

        return x;
    }

    private int findInterval(double[] x, double point) {
        int i = 0;
        while (i < x.length - 2 && point > x[i + 1]) {
            i++;
        }
        return i;
    }

    private double evaluateSpline(double[] x, double[] y, double[] m,
                                  int i, double point) {

        double h = x[i + 1] - x[i];

        double a = (x[i + 1] - point) / h;
        double b = (point - x[i]) / h;

        return a * y[i]
                + b * y[i + 1]
                + ((a * a * a - a) * m[i]
                + (b * b * b - b) * m[i + 1]) * (h * h / 6.0);
    }
}