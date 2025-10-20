package SoftComputing.interfaces;

import SoftComputing.Chromosomes.Chromosome;

import java.util.List;

public interface SelectionStrategy {
    List<Chromosome> select(List<Chromosome> population, int numberToSelect);
}