package SoftComputing.Core;

import SoftComputing.Chromosomes.Chromosome;
import SoftComputing.interfaces.InfeasibilityHandler;

import java.util.*;

public class InfeasibilityHandlerImpl implements InfeasibilityHandler {

    @Override
    public boolean isFeasible(Chromosome individual) {
        if (individual instanceof SoftComputing.Chromosomes.IntegerChromosome) {
            SoftComputing.Chromosomes.IntegerChromosome ind =
                    (SoftComputing.Chromosomes.IntegerChromosome) individual;
            List<Integer> genes = ind.getGenes();
            Set<Integer> unique = new HashSet<>(genes);
            return unique.size() == genes.size();
        }
        return true;
    }

    @Override
    public Chromosome repair(Chromosome individual) {
        if (individual instanceof SoftComputing.Chromosomes.IntegerChromosome) {
            SoftComputing.Chromosomes.IntegerChromosome ind =
                    (SoftComputing.Chromosomes.IntegerChromosome) individual;
            List<Integer> genes = new ArrayList<>(ind.getGenes());
            Set<Integer> seen = new HashSet<>();
            Random rand = new Random();

            for (int i = 0; i < genes.size(); i++) {
                int gene = genes.get(i);
                if (seen.contains(gene)) {
                    int newGene;
                    do {
                        newGene = rand.nextInt(genes.size());
                    } while (seen.contains(newGene));
                    genes.set(i, newGene);
                }
                seen.add(genes.get(i));
            }

            SoftComputing.Chromosomes.IntegerChromosome fixed =
                    new SoftComputing.Chromosomes.IntegerChromosome(genes.size(), 0, genes.size() - 1);
            for (int i = 0; i < genes.size(); i++) {
                fixed.setGene(i, genes.get(i));
            }
            return fixed;
        }
        return individual.copy();
    }
}
