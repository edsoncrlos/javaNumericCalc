package br.ufma.edson.javacalc.integration.gaussian;

public class TorqueFunction implements Function {
    @Override
    public double evaluate(double x) {
        return 5 * Math.pow(x, 3)
                + Math.pow(x, 2)
                - 12 * x
                + 4;
    }
}
