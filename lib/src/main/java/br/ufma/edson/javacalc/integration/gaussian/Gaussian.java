package br.ufma.edson.javacalc.integration.gaussian;

public interface Gaussian {
    double gaussianQuadrature(Function function, double a, double b, int n);
}