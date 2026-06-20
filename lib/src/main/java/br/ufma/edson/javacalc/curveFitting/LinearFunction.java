package br.ufma.edson.javacalc.curveFitting;

public record LinearFunction(double a, double b) {

    public double evaluate(double x) {
        return a * x + b;
    }
}
