package br.ufma.edson.javacalc.curveFitting;

public class LeastSquares implements CurveFitting {
    private LinearFunction linearFunction;
    private final double[] x;
    private final  double[] y;

    LeastSquares(double[] x, double[] y) {
        this.x = x;
        this.y = y;

        fit();
    }

    private void fit() {
        int n = x.length;

        double sumX = 0.0;
        double sumY = 0.0;
        double sumXY = 0.0;
        double sumXX = 0.0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumXX += x[i] * x[i];
        }

        double denominator = n * sumXX - sumX * sumX;

        if (denominator == 0) {
            throw new ArithmeticException("Can't be denominator is equal to 0");
        }

        double a = (n * sumXY - sumX * sumY) / denominator;
        double b = (sumY - a * sumX) / n;

        this.linearFunction = new LinearFunction(a, b);
    }

    @Override
    public double getValueA() {
        return linearFunction.a();
    }

    @Override
    public double getValueB() {
        return linearFunction.b();
    }

    @Override
    public double evaluate(double x) {
        return linearFunction.evaluate(x);
    }
}
