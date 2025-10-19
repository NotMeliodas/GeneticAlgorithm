package SoftComputing.Chromosomes;

public interface Chromosome {
    double getFitness();
    void setFitness(double fitness);
    Chromosome copy();
}
