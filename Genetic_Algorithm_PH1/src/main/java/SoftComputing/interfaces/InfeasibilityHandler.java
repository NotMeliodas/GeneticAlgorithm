package SoftComputing.interfaces;

import SoftComputing.Chromosomes.Chromosome;

public interface InfeasibilityHandler {
    boolean isFeasible(Chromosome individual);
    Chromosome repair(Chromosome individual);
}