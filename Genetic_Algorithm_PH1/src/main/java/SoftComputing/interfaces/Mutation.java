package SoftComputing.interfaces;

import SoftComputing.Chromosomes.Chromosome;

public interface Mutation {
    void mutate(Chromosome chromosome, double mutationRate);
}
