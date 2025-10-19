package SoftComputing.interfaces;

import java.util.List;

public interface SelectionStrategy {
    List<Chromosomes> select(List<Chromosome> population, int numberToSelect);
}