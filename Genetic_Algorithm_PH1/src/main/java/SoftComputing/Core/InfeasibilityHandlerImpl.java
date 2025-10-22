package SoftComputing.Core;

import SoftComputing.Chromosomes.Chromosome;
import SoftComputing.Chromosomes.IntegerChromosome;
import SoftComputing.interfaces.InfeasibilityHandler;

import java.util.*;


public class InfeasibilityHandlerImpl implements InfeasibilityHandler {

    @Override
    public boolean isFeasible(Chromosome individual) {
        if (individual instanceof IntegerChromosome) {
            IntegerChromosome ind = (IntegerChromosome) individual;
            List<Integer> genes = ind.getGenes();
            Set<Integer> unique = new HashSet<>(genes);
            return unique.size() == genes.size();
        }
        return true;
    }

    @Override
    public Chromosome repair(Chromosome individual) {
        if (individual instanceof IntegerChromosome) {
            IntegerChromosome ind = (IntegerChromosome) individual;
            List<Integer> genes = new ArrayList<>(ind.getGenes());
            Set<Integer> seen = new HashSet<>();
            Random rand = new Random();

            int n = genes.size();


            Set<Integer> available = new HashSet<>();
            for (int i = 0; i < n; i++) {
                available.add(i);
            }


            for (int g : genes) {
                available.remove(g);
            }


            for (int i = 0; i < n; i++) {
                int gene = genes.get(i);
                if (seen.contains(gene)) {
                    // Replace with a missing value if available
                    if (!available.isEmpty()) {
                        int newGene = available.iterator().next();
                        available.remove(newGene);
                        genes.set(i, newGene);
                    } else {
                        int newGene;
                        do {
                            newGene = rand.nextInt(n);
                        } while (seen.contains(newGene));
                        genes.set(i, newGene);
                    }
                }
                seen.add(genes.get(i));
            }

            IntegerChromosome repaired = new IntegerChromosome(genes);
            repaired.setFitness(ind.getFitness());
            return repaired;
        }

        return individual.copy();
    }
}
