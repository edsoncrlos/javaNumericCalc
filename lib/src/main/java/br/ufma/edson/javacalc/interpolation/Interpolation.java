package br.ufma.edson.javacalc.interpolation;

//TODO: Throw exception if x and y have different lengths
//TODO: Throw exceptio if x has duplicate values
public interface Interpolation {
    double interpolate(double[] x, double[] y, double point);
}
