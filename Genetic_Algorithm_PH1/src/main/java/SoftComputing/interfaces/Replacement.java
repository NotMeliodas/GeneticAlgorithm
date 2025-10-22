package SoftComputing.interfaces;

import SoftComputing.Chromosomes.Chromosome;
import java.util.List;

public interface Replacement {
    List<Chromosome> replace(List<Chromosome> oldPopulation, List<Chromosome> newPopulation);
}
