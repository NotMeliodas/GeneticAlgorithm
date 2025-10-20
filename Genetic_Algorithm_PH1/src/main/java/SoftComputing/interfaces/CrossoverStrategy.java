package SoftComputing.interfaces;

import SoftComputing.Chromosomes.Chromosome;

public interface CrossoverStrategy  {
    Chromosome[] crossover(Chromosome parent1, Chromosome parent2);
}
